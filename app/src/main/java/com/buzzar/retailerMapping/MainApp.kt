package com.buzzar.retailerMapping

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.buzzar.retailerMapping.models.ShopData
import com.buzzar.retailerMapping.screens.CameraScreen
import com.buzzar.retailerMapping.screens.ShopInputScreen
import com.buzzar.retailerMapping.screens.ShopListScreen
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnrememberedMutableState")
@Composable
fun ShopApp() {

    val shops = mutableStateOf(listOf<ShopData>())

    val scaffoldState = rememberScaffoldState()
    val lazyScroll = rememberScrollState()
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()


    MainScreen(coroutineScope,scaffoldState,navController,lazyScroll,shops)

}

@Composable
fun MainScreen(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController, scrollState: ScrollState, drinks: MutableState<List<ShopData>>) {

    Navigation(navController =navController,
        drinks = drinks,
        scaffoldState = scaffoldState,
        lazyScroll = scrollState,
        coroutineScope = scope
    )

}

@Composable
fun Navigation(navController: NavHostController,
               drinks: MutableState<List<ShopData>>,
               scaffoldState: ScaffoldState,
               lazyScroll: ScrollState,
               coroutineScope: CoroutineScope
) {
    NavHost(navController = navController, startDestination = "ShopListScreen",

        ) {
        composable("ShopListScreen") {
            ShopListScreen(scaffoldState = scaffoldState,
                lazyScroll = lazyScroll,
                navController = navController,
                coroutineScope = coroutineScope,
                shops = drinks)
        }

        composable("ShopInputScreen") {
            ShopInputScreen(navController = navController,)
        }


        composable("CameraScreen") {
            CameraScreen()
        }
    }

}