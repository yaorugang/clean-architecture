package com.yaorugang.afterpay.test

import com.yaorugang.afterpay.domain.exception.DomainException
import com.yaorugang.afterpay.domain.exception.EmptyDataException
import com.yaorugang.afterpay.domain.manager.CarsManager
import com.yaorugang.afterpay.mock.MockCarsRepository
import com.yaorugang.afterpay.mock.MockEmptyCarsRepository
import com.yaorugang.afterpay.mock.MockErrorCarsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals

class CarsManagerTest {

    private lateinit var carsManager: CarsManager

    @Test
    fun testNonEmptyCars() = runBlocking {
        carsManager = CarsManager(MockCarsRepository())
        val carList = carsManager.getCars()

        assertEquals(3, carList.size)

        assertEquals("BMW", carList[1].make.manufacturer)
        assertEquals("X7", carList[1].make.model)
        assertEquals(6, carList[1].configuration.cylinders)
        assertEquals(240, carList[1].configuration.horsepower)
        assertEquals(2020, carList[1].year)
        assertEquals(47000, carList[1].price)

        assertEquals("Hyundai", carList[2].make.manufacturer)
        assertEquals("Atos Prime", carList[2].make.model)
        assertEquals(4, carList[2].configuration.cylinders)
        assertEquals(100, carList[2].configuration.horsepower)
        assertEquals(2010, carList[2].year)
        assertEquals(9000, carList[2].price)
    }

    @Test
    fun testEmptyCars() = runBlocking {
        carsManager = CarsManager(MockEmptyCarsRepository())
        var emptyDataExceptionThrown = false

        try {
            carsManager.getCars()
        } catch (e: EmptyDataException) {
            emptyDataExceptionThrown = true
        }

        assertEquals(true, emptyDataExceptionThrown)
    }

    @Test
    fun testFetchingCarsError() = runBlocking {
        carsManager = CarsManager(MockErrorCarsRepository())
        var domainExceptionThrown = false

        try {
            carsManager.getCars()
        } catch (e: DomainException) {
            domainExceptionThrown = true
        }

        assertEquals(true, domainExceptionThrown)
    }
}