package com.example.mvvm.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mvvm.datasources.GameRemoteDataSource
import com.example.mvvm.network.GameAPIsService
import com.example.mvvm.repository.GameRepository
import com.example.mvvm.ui.gallery.GameViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private lateinit var repository: GameRepository
    private lateinit var dataSource: GameRemoteDataSource
    private val testDispatcher = TestCoroutineDispatcher()


    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var apiService: GameAPIsService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        dataSource = GameRemoteDataSource(apiService)
        repository = GameRepository(dataSource)
        viewModel = GameViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `change password`() = runBlockingTest {
        val liveData = viewModel.gamesList.value
        val response = repository.getGames("apikeybcbcn", 10, 1)
        assertThat(liveData).isEqualTo(response)
    }
}