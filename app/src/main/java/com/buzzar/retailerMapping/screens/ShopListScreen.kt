package com.buzzar.retailerMapping.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.buzzar.retailerMapping.models.ShopData
import com.buzzar.retailerMapping.shopMockList
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopListScreen(scaffoldState: ScaffoldState,
                   lazyScroll: ScrollState,
                   navController: NavController,
                   coroutineScope: CoroutineScope,
                   shops: MutableState<List<ShopData>>) {
    Scaffold(scaffoldState = scaffoldState,
        topBar = {ShopAddScreen(navController = navController, shops = shops)}) {
        ShopList(navController = navController, scrollState = lazyScroll, shopList = shops.value)
    }


}

@Composable
fun ShopAddScreen(navController: NavController, shops: MutableState<List<ShopData>>) {
    Box() {
        Text(text = "All Kirana Stores",
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomEnd).padding(end = 12.dp)) {
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add Shop",
                modifier = Modifier
                    .size(25.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        navController.navigate("ShopInputScreen")
                    }
            )
        }
    }
}

@Composable
fun ShopList(navController: NavController, scrollState: ScrollState, shopList: List<ShopData>) {
    Box(
        modifier = Modifier
            .padding(6.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .scrollable(scrollState, Orientation.Vertical)
        ) {
            items(shopMockList) { shopData ->
                ShopListItem(shopData = shopData)
            }
        }
    }
}

@Composable
fun ShopListItem(shopData: ShopData) {
    Box(modifier = Modifier.padding(5.dp)
    )
    {
        Card(shape = RoundedCornerShape(5.dp),
            elevation = 6.dp,
            backgroundColor = if (shopData.idShop.toInt() % 2 != 0) Color.hsl(200f, 0.30f, 0.95f) else Color.hsl(200f, 1f, 0.95f),

        ) {
           Row(modifier = Modifier
               .fillMaxWidth()
               .padding(5.dp)
               .requiredHeight(120.dp)) {
               Column(Modifier.weight(7f)) {
                       Row {
                           Text(text = "Store Name: ",
                               fontSize = 16.sp,
                               fontFamily = FontFamily.SansSerif,
                               fontWeight = FontWeight.SemiBold,
                               textAlign = TextAlign.Start,
                               modifier = Modifier.padding(5.dp)
                           )

                              Text(text = shopData.shopName,
                                fontSize = 15.sp,
                                  fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(5.dp)
                              )

                       }
                         Row {
                              Text(text = "Owner Name: ",
                                fontSize = 16.sp, fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(5.dp)
                              )

                              Text(text = shopData.ownerName,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(5.dp)
                              )
                         }
                       Row {
                           Text(text = "Area: ",
                               fontSize = 16.sp,
                                fontFamily = FontFamily.SansSerif,
                               fontWeight = FontWeight.SemiBold,
                               textAlign = TextAlign.Start,
                               modifier = Modifier.padding(5.dp)
                           )

                           Text(text = shopData.shopAddress,
                               fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                               fontWeight = FontWeight.Medium,
                               modifier = Modifier.padding(5.dp)
                           )
                       }
                   Row {
                       Text(text = "Category: ",
                           fontSize = 16.sp,
                           fontFamily = FontFamily.SansSerif,
                           fontWeight = FontWeight.SemiBold,
                           textAlign = TextAlign.Start,
                           modifier = Modifier.padding(5.dp)
                       )

                       Text(text = shopData.shopType,
                           fontSize = 15.sp,
                           fontFamily = FontFamily.SansSerif,
                           fontWeight = FontWeight.Medium,
                           modifier = Modifier.padding(5.dp)
                       )

                   }
               }

               Box(contentAlignment = Alignment.BottomEnd,
                   modifier = Modifier
                       .fillMaxSize()
                       .weight(3f)
               ) {
                   Text(text = shopData.shopTime,
                       fontSize = 12.sp,
                       fontFamily = FontFamily.SansSerif,
                       fontWeight = FontWeight.Medium,
                       textAlign = TextAlign.End,
                       modifier = Modifier
                           .padding(5.dp)
                           .wrapContentHeight(Alignment.Bottom)
                   )

               }




           }

        }
    }
}

@Preview
@Composable
fun ShopListItemPreview() {
ShopListItem(ShopData("Shop 1", "Address 1", "City 1", "State 1", "Country 1", "Zip 1", "5 Days Ago"),)
}
