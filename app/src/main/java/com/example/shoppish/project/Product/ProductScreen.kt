package com.example.shoppish.project.Product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material.DropdownMenuItem
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.BottomSheets.ModalBottomSizeSheet
import com.example.shoppish.project.MVVM.ProductViewModel
import com.example.shoppish.project.Product.Child.ChildGridProduct
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.Gray
import com.example.shoppish.ui.theme.metropolisFamilyFont


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductScreen(navController: NavController) {
        TopAppBarDefaults.topAppBarColors()
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)

        }
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = MaterialTheme.colorScheme.primary,

                        ),
                    title = {
                        androidx.compose.material3.Text (
                            "Centered Top App Bar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(ShopScreen.BrandFilter.route) }) {
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
                    scrollBehavior = scrollBehavior,
                )
            },
        ) { innerPadding ->
            ProductScroll(4.5, innerPadding = innerPadding,
                navController = navController, viewModel = ProductViewModel())
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Your other composables go here...

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(104.dp)
                    .background(Color.White,)
                    .shadow(2.dp, RectangleShape, true)

            ) {
                // Your content here

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.Center)
                    )  {
                        Button(
                                onClick = { isSheetOpen = true },
                            modifier = Modifier
                                .size(width = 343.dp, height = 48.dp)
                                .padding(end = 13.dp),
                            shape = RoundedCornerShape(26.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                        ) {
                            androidx.compose.material3.Text(
                                text = "ADD TO CART",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = metropolisFamilyFont
                            )
                        }

                    }
                    if(isSheetOpen){
                        ModalBottomSheet(
                            sheetState = sheetState ,
                            onDismissRequest = { isSheetOpen = false }
                        ) {
                            Box(modifier = Modifier.background(Color.White)) {
                                ModalBottomSizeSheet()
                            }
                        }
                    }
                }

            }
        }
    }


@Composable
fun ProductScroll(
    rating: Double, max: Int = 5,
    innerPadding: PaddingValues,
    navController: NavController,
    viewModel: ProductViewModel
) {
    val childProducts = viewModel.childProducts


    val dressSizes = listOf("Small", "Medium", "Large", "X-Large", "XX-Large")
    val dressColors = listOf("Red", "Blue", "Green", "Black", "White")

    var selectedSize by remember { mutableStateOf(dressSizes[0]) }
    var selectedColor by remember { mutableStateOf(dressColors[0]) }

    var expandedSize by remember { mutableStateOf(false) }
    var expandedColor by remember { mutableStateOf(false) }

    var favProduct by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Box (
    modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
){
 Column(
     modifier = Modifier
         .fillMaxSize()
         .background(Color(0xFFF9F9F9))
         .verticalScroll(scrollState)
 ) {

     Box {
         Row(
             modifier = Modifier
                 .fillMaxWidth()
                 .horizontalScroll(rememberScrollState())
         ) {
             Box {
                Image(painter = painterResource(id = R.drawable.dress),
                    contentDescription = null,
                    modifier = Modifier.size(width = 275.dp, height = 413.dp))
             }
             Box {
                 Image(painter = painterResource(id = R.drawable.dressside),
                     contentDescription = null,
                     modifier = Modifier.size(width = 275.dp, height = 413.dp))

             }
         }

     }


     Row(
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp)

     )  {
         Box(modifier = Modifier
             .height(40.dp)
             .width(138.dp)
             .padding(start = 18.dp)) {
             Button(onClick = { expandedSize = true },
                 modifier = Modifier
                     .border(
                         width = 1.dp,
                         color = Color.LightGray,
                         RoundedCornerShape(10.dp)
                     ),
                 colors = ButtonDefaults.buttonColors(backgroundColor = (Color(0xFFF9F9F9)))) {
                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     androidx.compose.material3.Text(selectedSize)
                     Icon(
                         imageVector = Icons.Filled.ArrowDropDown,
                         contentDescription = "Dropdown arrow",
                         modifier = Modifier.padding(end = 2.dp)
                     )
                 }
             }
             DropdownMenu(
                 expanded = expandedSize,
                 onDismissRequest = { expandedSize = false }
             ) {
                 dressSizes.forEach { size ->
                     DropdownMenuItem(onClick = {
                         selectedSize = size
                         expandedSize = false
                     }) {
                         androidx.compose.material3.Text(size)
                     }
                 }
             }
         }

         Spacer(modifier = Modifier.height(16.dp))

         Box(modifier = Modifier
             .size(138.dp, 40.dp)
             .padding(start = 18.dp)) {
             Button(onClick = { expandedColor = true },
                 modifier = Modifier
                     .width(138.dp)
                     .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(10.dp)),
                 colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     androidx.compose.material3.Text(selectedColor)
                     Icon(
                         imageVector = Icons.Filled.ArrowDropDown,
                         contentDescription = "Dropdown arrow",
                         modifier = Modifier.padding(end = 2.dp)
                     )
                 }
             }
             DropdownMenu(
                 expanded = expandedColor,
                 onDismissRequest = { expandedColor = false }
             ) {
                 dressColors.forEach { color ->
                     DropdownMenuItem(onClick = {
                         selectedColor = color
                         expandedColor = false
                     }) {
                         androidx.compose.material3.Text(color)
                     }
                 }
             }
         }
         Spacer(modifier = Modifier.width(20.dp))
         Box(
             modifier = Modifier
                 .size(45.dp)
                 .clip(CircleShape)

                 .border(BorderStroke(2.dp, Color.LightGray), RoundedCornerShape(25.dp)),


         ) {
             IconButton(onClick = { favProduct = !favProduct },
                 ) { // Toggle favProduct when the button is clicked
                 Icon(
                     painter = painterResource(id = if (favProduct) R.drawable.favselected else R.drawable.favunselected), // Change the icon based on favProduct
                     contentDescription = "Favorite",
                     tint = if (favProduct) Color(0xFFFF6347) else Color.Black
                 )
             }

         }


     }

     Row (
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 32.dp, start = 18.dp, end = 18.dp),
         horizontalArrangement = Arrangement.SpaceBetween

     ){
         androidx.compose.material3.Text(text = product.name ,
             fontFamily = metropolisFamilyFont,
             fontSize = 30.sp,
             color = Color.Black,
             fontWeight = FontWeight.Bold)


         androidx.compose.material3.Text(text = "$ " + product.price.toString()  ,
             fontFamily = metropolisFamilyFont,
             fontSize = 30.sp,
             color = Color.Black,
             fontWeight = FontWeight.Bold)
     }
     androidx.compose.material3.Text(text = product.title,
         fontFamily = metropolisFamilyFont,
         fontSize = 16.sp,
         color = Color.Gray,
         fontWeight = FontWeight.Normal,
         modifier = Modifier.padding(start = 18.dp, top = 6.dp))

     Row (
         modifier = Modifier.padding(start = 18.dp)
             .clickable { navController.navigate(ShopScreen.RatingScreen.route) },
     ){
         for (i in 1..max) {
             val image = when {
                 i <= rating.toInt() -> R.drawable.full_star
                 i - 1 < rating -> R.drawable.star_half
                 else -> R.drawable.star_empty
             }
             Box(
                 modifier = Modifier.width(15.dp), // Adjust this value to control the distance between the stars
                 contentAlignment = Alignment.Center
             ) {
                 Image(
                     painter = painterResource(id = image),
                     contentDescription = "Star",
                     modifier = Modifier.size(28.dp)

                 )
             }
         }
         androidx.compose.material3.Text(
             text = "(${product.noOfReviews})",
             modifier = Modifier
                 .padding(start = 3.dp, top = 7.dp),
             style = TextStyle(
                 color = Color(0xFF9B9B9B),
                 fontFamily = metropolisFamilyFont,
                 fontWeight = FontWeight.Light,
                 fontSize = 10.sp
             )
         )
     }
       Text(text = product.description,
           fontFamily = metropolisFamilyFont,
           fontSize = 16.sp,
           color = Color.Black,
           fontWeight = FontWeight.Normal,
           modifier = Modifier.padding(start = 18.dp, top = 6.dp),
           style = TextStyle(lineHeight = 24.sp,letterSpacing = 1.sp)
       )

     TabRowDefaults.Divider(
         color = Gray,
         thickness = 0.4.dp,
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 36.dp)
     )

     Row(
         modifier = Modifier
             .fillMaxWidth()
             .height(50.dp),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically
     ) {

         Text(text = "Shipping Info",
             fontFamily = metropolisFamilyFont,
             fontSize = 16.sp,
             color = Color.Black,
             fontWeight = FontWeight.SemiBold,
             modifier = Modifier.padding(start = 18.dp, top = 6.dp),
             style = TextStyle(letterSpacing = 1.sp)
         )

         Icon(imageVector = Icons.Filled.KeyboardArrowRight,
             contentDescription = "Dropdown arrow",
             modifier = Modifier.padding(end = 18.dp) )

     }

     TabRowDefaults.Divider(
         color = Gray,
         thickness = 0.4.dp,
         modifier = Modifier
             .fillMaxWidth()
     )

     Row(
         modifier = Modifier
             .fillMaxWidth()
             .height(50.dp),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically
     ) {

         Text(text = "Support",
             fontFamily = metropolisFamilyFont,
             fontSize = 16.sp,
             color = Color.Black,
             fontWeight = FontWeight.SemiBold,
             modifier = Modifier.padding(start = 18.dp, top = 6.dp),
             style = TextStyle(letterSpacing = 1.sp)
         )

         Icon(imageVector = Icons.Filled.KeyboardArrowRight,
             contentDescription = "Dropdown arrow",
             modifier = Modifier.padding(end = 18.dp) )

     }

     TabRowDefaults.Divider(
         color = Gray,
         thickness = 0.4.dp,
         modifier = Modifier
             .fillMaxWidth()
     )

     Row (
         modifier = Modifier.fillMaxWidth()
     ){

         Text(text = "You can also like this",
             fontFamily = metropolisFamilyFont,
             fontSize = 19.sp,
             color = Color.Black,
             fontWeight = FontWeight.SemiBold,
             modifier = Modifier.padding(start = 18.dp, top = 24.dp),
             style = TextStyle(lineHeight = 24.sp,letterSpacing = 1.sp)
         )

     }

     Spacer(modifier = Modifier.height(16.dp))
     LazyRow {



         items(20) { // Replace 20 with the number of times you want to display the image
             ChildGridProduct(product = childProducts[0], imageUrl = childProducts[0].imageUrlGrid)

             // Add space between images
         }
     }
     Box (
         modifier = Modifier.fillMaxWidth()
             .height(100.dp)
     ){

     }


 }
}

}

data class ProductContent(
    val image: String,
    val imageSide: String,
    val name: String,
    val title: String,
    val description: String,
    val price: Double,
    val rating: Float,
    val discount: Double,
    val noOfReviews: Double,
)

val product = ProductContent(
    image = R.drawable.dress.toString(), // replace "image_name" with your actual drawable image name
    imageSide = R.drawable.dressside.toString(), // replace "image_name" with your actual drawable image name
    name = "H&M",
    title = "Short Dress",
    description = "Short dress in soft cotton jersey with decorative buttons down the front and a wide, frill-trimmed square neckline with concealed elastication. Elasticated seam under the bust and short puff sleeves with a small frill trim.",
    price = 99.99,
    rating = 5f,
    discount = 10.0 ,
    noOfReviews = 10.0
)


@Composable
@Preview
fun ProductScreenPreview(){
    ProductScreen( navController = rememberNavController())
//    ProductScroll( rating = 4.5, max = 5)
}


