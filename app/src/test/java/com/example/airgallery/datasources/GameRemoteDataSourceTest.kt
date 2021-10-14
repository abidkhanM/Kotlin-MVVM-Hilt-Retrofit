package com.example.airgallery.datasources

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.airgallery.network.GameAPIsService
import com.example.airgallery.utils.anyValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class GameRemoteDataSourceTest {


    @get:Rule
    val taskExecutor = InstantTaskExecutorRule()


    @Mock
    private lateinit var apiService: GameAPIsService

    private var testDispatcher = TestCoroutineDispatcher()

    private lateinit var dataSource: GameRemoteDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        dataSource = GameRemoteDataSource(apiService)
    }

    @Test
    fun `get game data`() = runBlockingTest {
        dataSource.getListDataOfGames("apikeybcbcn", 10, 1)
        Mockito.verify(apiService).getListOfGames("apikeybcbcn", 10, 1)
    }
}