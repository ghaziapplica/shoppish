package com.example.shoppish.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.ProcessingPreview
import com.example.shoppish.R
import com.example.shoppish.project.neww.ProfileDetailScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrder(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    var selectedButton by remember { mutableStateOf("Delivered") }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                LargeTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        scrolledContainerColor = Color.White,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            "My Orders",
                            style = TextStyle(
                                color = Color.Black,
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Bold,
                                fontSize = 34.sp
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.clickable { navController.navigate(ProfileDetailScreen.OrderDetails.route) }
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
                androidx.compose.material.Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(74.dp),
                    backgroundColor = Color.White,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomButton("Delivered", selectedButton) { selectedButton = it }
                        CustomButton("Processing", selectedButton) { selectedButton = it }
                        CustomButton("Cancelled", selectedButton) { selectedButton = it }
                    }
                }
            }
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (selectedButton == "Delivered") {
                DeliveredPreview(navController = navController)
            } else if (selectedButton == "Processing") {
                ProcessingPreview(navController)
            } else if (selectedButton == "Cancelled") {
                CancelledPreview(navController)
            }
        }
    }
}

@Composable
fun CustomButton(text: String, selectedButton: String, onClick: (String) -> Unit) {
    val isSelected = selectedButton == text
    val backgroundColor = if (isSelected) Color.Black else Color.White
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(30.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(15.dp))
            .clickable { onClick(text) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = textColor, fontSize = 14.sp,
            fontFamily = metropolisFamilyFont,
            fontWeight = FontWeight.Normal,
            )
    }
}
@Composable
@Preview
fun MyOrderPreview() {
    MyOrder( rememberNavController())
}