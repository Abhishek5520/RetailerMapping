package com.buzzar.retailerMapping.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ShopInputScreen(navController: NavController) {
    var ownerName by remember { mutableStateOf(TextFieldValue("")) }
    var shopName by remember { mutableStateOf(TextFieldValue("")) }
    var shopAddress by remember { mutableStateOf(TextFieldValue("")) }
    var shopContact by remember { mutableStateOf(TextFieldValue("")) }
    val shopTypeList = arrayOf("Big", "Small", "Very Small", "Very Big", "Medium", "Large")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(9.dp)) {
        Card(modifier = Modifier
            .align(Alignment.Center)
            .defaultMinSize(500.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                ) {
                Text(text = "Enter Shop details", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(8.dp, bottom = 20.dp))
                TextField(
                    value = ownerName , onValueChange = {it-> ownerName = it},
                    textStyle = MaterialTheme.typography.body1,
                    label = { Text("Shop Owner Name") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.hsl(21f, 1f, 0.50f),
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        textColor = Color.Black,
                    ),
                )
                TextField(
                    value = shopName , onValueChange = {it-> shopName = it},
                    textStyle = MaterialTheme.typography.body1,
                    label = { Text("Shop Name") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.hsl(21f, 1f, 0.50f),
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        textColor = Color.Black,
                    ),

                )
                TextField(
                    value = shopAddress , onValueChange = {it-> shopAddress = it},
                    textStyle = MaterialTheme.typography.body1,
                    label = { Text("Shop address") }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.hsl(21f, 1f, 0.50f),
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        textColor = Color.Black,
                    ),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.AddLocation,
                                contentDescription = "Search Icon",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    },
                )
                TextField(
                    value = shopContact, onValueChange = { it -> shopContact = it },
                    textStyle = MaterialTheme.typography.body1,
                    placeholder = { Text("Business Contact(if applicable)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        textColor = Color.Black,
                    ),
                )

                ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
                    expanded = !expanded
                }) {
                    TextField(
                        value = selectedText,
                        placeholder = { Text("Shop Type") },
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.LightGray,
                            focusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = Color.hsl(21f, 1f, 0.50f),
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            cursorColor = Color.Black,
                            textColor = Color.Black,
                        ),
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        shopTypeList.forEach { item ->
                            DropdownMenuItem(onClick = {
                                selectedText = item
                                expanded = false
                            }) {
                                Text(text = item)
                            }
                        }
                    }

                }

            }
            Button(onClick = {navController.navigate("CameraScreen")}, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp).
                align(Alignment.End),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.hsl(21f, 1f, 0.58f))
            ) {
                Text("Continue", fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(8.dp))
            }
        }
    }
}


