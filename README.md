# Android CLEAN Architecture example
_Rugang Yao. 07/06/2022_

## Environment
To run this project you need JDK 11 installed.


## Tech stack:
| Category      | Technology                                            |
| ------------- |:-----------------------------------------------------:|
| Language      | Kotlin                                                |
| Threading     | Coroutine                                             |
| API call      | Retrofit                                              |
| Injection     | Dagger 2                                              |
| UI            | Single activity + Navigation Controller + DataBinding |


## Architecture
The project uses __CLEAN Architecture__, which consist of 3 layers:

### Domain Layer
* This is an independent layer contains only business logic written by pure kotlin, which means it doesn't refer to any android framework.

* In the domain layer, there a manager class called `CarsManager` (while some develops call managers as UseCases) which handles business logic or processing business data, in our case, it's fetching car list by calling `carsRepository` and handling exceptions. The `CarsRepository` interface is also defined in the domain layer, which would be used in data layer for providing the repository implementation and in unit test for providing mock repository implementations.

* Domain model (e.g Car) and Domain exceptions are all business related, they will be used in the UI layer.

* Domain layer can be migrate to other platform, for example Microsoft Windows, and highly likely on iOS in the future.


### Data Layer
* Provide actual implementation for repository that defined in the Domain layer, in which I use retrofit to make api call.

* Mapper classes in the data layer are usd for converting api response entity to domain model. Since  the `Car` model is simple, we don't
  have complex mapping logic to process, so in the `CarMapper` we can see almost one-to-one mapping except the `imageUrl` value.

* We should also have exceptions mappers that will be used for converting low-level exceptions to Domain exceptions (human readable exception).
  However, due to time limit I didn't provide complete exception handing mechanism. The 2 domain exceptions already well handled our case.

* Data layer is platform specific, not able to migrate to other platform.


### UI layer
* UI layer mainly contains Views and ViewModels. Domain managers are injected into ViewModels. In our case, the `CarListViewModel` fetch
  car data via `CarsManager` and then display car's information on the view via LiveData.

* I use single activity design with the support of Navigation controller. The `CarListFragment` is the main screen that user can see.

* DataBinding is used for RecyclerView and ImageView with suspendCoroutine to achieve on-demand car image loading. DataBinding also
  helped to simplify UI inflation codes.

* As per request, the app supports screen rotation via viewModels maintaining UI states. So no need to do extra work to handle instance state.
  (I have to mention ViewModel cannot replace instance state)


## Security
Provided the security config file to support HTTPS call and debug while using tools like Charles


## Testing
* Provide unit tests for Domain layer and UI ViewModel, specifically testing the `CarsManager` class and `CarListViewModel` class

* The code challenge doesn't require to provide UI test, but it will be good to provide UI test in actual project. I normally use
  Expresso + cucumber for UI testing
