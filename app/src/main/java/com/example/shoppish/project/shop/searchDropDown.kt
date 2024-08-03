package com.example.shoppish.project.shop

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.neww.ShopScreen
//import com.example.shoppish.project.MVVM.Screen
import com.example.shoppish.ui.theme.Gray
import com.example.shoppish.ui.theme.poppinsFamilyFont
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DropDownScreen(navController: NavController,
                   onClick: () -> Unit,
                   viewModel: ShopViewModel) {

//    val systemUiController = rememberSystemUiController()
//
//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = Color.Transparent,
//            darkIcons = false
//        )
//
//    }


    Box() {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
//                contentColor = colorResource(id = R.color.white)
        ),
        onClick = {   },
    )

    {
        Text(text = viewModel.viewAll,
            style = TextStyle(
                color = colorResource(id = R.color.white),
                fontFamily = poppinsFamilyFont,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
        )

    }
        Text(text = viewModel.choose,
            style = TextStyle(
                color = Gray,
                fontFamily = poppinsFamilyFont,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )

        Box (
            modifier = Modifier.padding(bottom = 100.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                viewModel.categoriesList.forEach { category ->
                    val context = LocalContext.current

                    Text(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 15.dp, bottom = 16.dp)
                            .let {
                                if (category == "Tops") it.clickable {
                                    Toast
                                        .makeText(context, "Tops clicked", Toast.LENGTH_SHORT)
                                        .show()
//                                  WomanTop()
                                    onClick()

                                }
                                else it
                            },
                        text = category,
                        // Add your text styles here
                    )
                    Divider(
                        color = Gray,
                        thickness = 0.4.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
//                    if (isTopClicked) {
//                        WomanTop()
//                    } else {
//                        CategoryScreen(bottomBar = {})
//                    }
//                    CategoryScreen(bottomBar = {})
                }
            }
        }




    }
    }
}
@Composable
@Preview(showBackground = true)
fun DropDownPreview(){
    DropDownScreen(rememberNavController(), onClick = {}, viewModel())

}
