package com.example.shoppish.project

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.shoppish.R
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun  RatingReviews(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }




    Scaffold(

        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = MaterialTheme.colorScheme.primary,

                    ),
                title = {
                    Text(
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
        Box(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Dummy Text 1",)
            Text(text = "Dummy Text 2")
            Button(onClick = { isSheetOpen = true }) {
                Text(text = "Dummy Button")
            }
            if(isSheetOpen){
                ModalBottomSheet(
                    onDismissRequest = { isSheetOpen = false }
                ) {
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight(0.8f) ) {
                        RatingSheet( isSelected = true)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reviews(rating: Double, max: Int = 5,){
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior (rememberTopAppBarState())
    val isScrolled = remember { derivedStateOf { scrollBehavior.state.contentOffset < -80f } }
    val topAppBarElementColor = if (isScrolled.value) {
        Color.White

    } else {
        Color.White
    }
    val topAppBarElementText = if (isScrolled.value) {
        TextStyle(
            fontSize =  24.sp
        )

    } else {
        TextStyle(
            fontSize =  34.sp
        )    }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                Column {

                }
                LargeTopAppBar(
                    modifier = Modifier
                        // Set the height as per your requirement
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = topAppBarElementColor,
                        titleContentColor = colorScheme.primary,
                    ),
                    title = {

                        Text(text = "Rating&Reviews",
                            style = TextStyle(
                                color = Color.Black,
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Bold,
                                fontSize =  topAppBarElementText.fontSize,),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        )


                    },


                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                tint = Color.Black,
                                contentDescription = "Localized description"
                            )
                        }
                    },

                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                tint = Color.Black,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )

            }
        },
    ) { values ->



        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
                .background(Color(0xFFF9F9F9))

        ){
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                RatingDisplay()

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 18.dp, end = 31.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(text = "${dummyReview.reviewNo} Reviews",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,)


                    Row {
                        Box (
                            modifier = Modifier
                                .size(30.dp)
                                .padding(bottom = 5.dp)
                        ){
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },

                                )
                        }

                        Text(text = "With photo",
                            fontFamily = metropolisFamilyFont,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top =  3.dp))

                    }

                }

                Box {
                    LazyColumn {

                        items(10) { index ->
                            Box(
                                modifier = Modifier
                                    .width(327.dp)
                                    .height(373.dp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .background(Color.White)
                                        .width(311.dp)
                                        .height(357.dp)
                                        .padding(top = 18.dp, start = 18.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    Column {

                                        Text(text = "Kim Shine",
                                            fontFamily = metropolisFamilyFont,
                                            fontSize = 16.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(bottom = 8.dp, top = 23.dp, start = 10.dp))

                                        Row(
                                            modifier = Modifier.padding(bottom = 17.dp, start = 10.dp),
                                        ) {
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
                                            Text(text = dummyReview.time,
                                                fontFamily = metropolisFamilyFont,
                                                fontSize = 12.sp,
                                                color = Color.Black,
                                                fontWeight = FontWeight.Light,
                                                modifier = Modifier.padding(start = 100.dp, top = 6.dp)
                                            )

                                        }
                                        Box(
                                            modifier = Modifier
                                                .size(width = 267.dp, height = 139.dp)
                                                .verticalScroll(rememberScrollState())
                                        ) {
                                            Text(
                                                text = "I loved this dress so much as soon as I tried it on I knew I had to buy it in another color. I am 5'3 about 155lbs and I carry all my weight in my upper body. When I put it on I felt like it thinned me put and I got so many compliments.",
                                                fontFamily = metropolisFamilyFont,
                                                fontSize = 14.sp,
                                                color = Color.Black,
                                                fontWeight = FontWeight.Light,
                                                modifier = Modifier.padding(10.dp)
                                            )
                                        }

                                        Row (
                                            modifier = Modifier.padding(10.dp),
                                        ){
                                            Image(painter = painterResource(id = dummyReview.photo),
                                                contentDescription = null,
                                                modifier = Modifier.size(104.dp))


                                        }


                                    }
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(200.dp) // Adjust the height to control the gradient effect area
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.White), // Change Color.Black to your desired color
                                    startY = 0f,
                                    endY = Float.POSITIVE_INFINITY
                                )
                            )
                    )
                }

            }
            if(isSheetOpen){
                ModalBottomSheet(
                    onDismissRequest = { isSheetOpen = false }
                ) {
                    Box(modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight(0.8f) ) {
                        RatingSheet( isSelected = true)
                    }
                }
            }
            FloatingActionButton(
                onClick = { isSheetOpen = true  },
                modifier = Modifier
                    .size(width = 160.dp, height = 38.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (-13).dp, y = (-20).dp)
                    .padding(end = 13.dp,),

                shape = RoundedCornerShape(26.dp),
                containerColor = Color(0xFFFF6347)
            ) {
                Row {
                    Icon(Icons.Filled.Create, contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 5.dp),)

                    Text(
                        text = "Write a Review",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = metropolisFamilyFont,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                }
            }
        }
    }

}


@Composable
fun RatingSheet(isSelected: Boolean,){
    var selectedStars by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("") }
    val cameraIcon = painterResource(id = R.drawable.camera)
    var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectedImageUris = uris }
    )



    Box (
        modifier = Modifier
            .fillMaxSize()
            .height(640.dp)
            .background(Color(0xFFF9F9F9))
    ){
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Text(text = "What is your rate?",
                    fontFamily = metropolisFamilyFont,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 17.dp))

                Row (
                    modifier = Modifier.padding(bottom = 34.dp),
                ){
                    for (i in 1..5) {
                        Image(
                            painter = if (i <= selectedStars)
                                painterResource(id = R.drawable.full_star)
                            else
                                painterResource(id = R.drawable.star_empty),
                            contentDescription = null,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clickable(onClick = { selectedStars = i })
                        )
                    }
                }

                Text(text = "Please share your opinion\n" +
                        "about the product",
                    fontFamily = metropolisFamilyFont,
                    fontSize = 19.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,)
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 19.dp),
                horizontalArrangement = Arrangement.Center,
            ){
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .width(327.dp)
                        .height(148.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(10.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp,
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {

                item {
                    Column (
                        modifier = Modifier
                            .width(154.dp)
                            .height(154.dp)
                            .padding(top = 45.dp, start = 30.dp)
                            .clickable {
                                multiplePhotoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            }
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){



                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(CircleShape)
                                .aspectRatio(1f)
                                .background(Color(0xFFDB3022)),
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = cameraIcon,
                                contentDescription = "Camera Icon"
                            )

                        }
                        Text(text = "Add Your Photo",
                            fontFamily = metropolisFamilyFont,
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                    }

                }


                items(selectedImageUris) { uri ->
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .size(154.dp)
                            .padding(start = 18.dp, top = 45.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    androidx.compose.material.Button(
                        onClick = { },
                        modifier = Modifier
                            .size(width = 343.dp, height = 48.dp)
                            .padding(end = 13.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                    ) {
                        Text(
                            text = "SEND REVIEW",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = metropolisFamilyFont
                        )
                    }

                }

            }




        }
    }
    }

@Composable
fun TestScreen(starCount: Int, lineLength: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display stars
        repeat(starCount) {

            Column {
                Image(
                    painter = painterResource(id = R.drawable.full_star),
                    contentDescription = "Star",
                    modifier = Modifier
                        .padding(end = 1.dp)
                        .size(24.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .height(8.dp)
                .padding(end = 5.dp)
                .clip(RoundedCornerShape(5.dp))
                .width(lineLength.dp)
                .background(Color.Red)
        )
    }
}

@Composable
fun RatingDisplay() {
    // Define the rating values
    val oneStar = 0
    val twoStar = 2
    val threeStar = 4
    val fourStar = 5
    val fiveStar = 12

    // Calculate net rating
    val totalRatings = oneStar + twoStar + threeStar + fourStar + fiveStar
    val netRating = if (totalRatings > 0) {
        (1 * oneStar + 2 * twoStar + 3 * threeStar + 4 * fourStar + 5 * fiveStar) / totalRatings.toFloat()
    } else {
        0f
    }
    Row (
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column (
            modifier = Modifier.padding(start = 10.dp)
        ){

            Text(
                text = "%.2f".format(netRating),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = metropolisFamilyFont,
                color = Color.Black, // This color changes based on the theme
                modifier = Modifier.padding(top = 18.dp)
            )
            Text(
                text = "$totalRatings rating${if (totalRatings > 1) "s" else ""}",
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 22.dp, top = 16.dp)
                .width(220.dp),

            ) {
            TestScreen(starCount = 5, lineLength = fiveStar *   6)
            TestScreen(starCount = 4, lineLength = fourStar *   6)
            TestScreen(starCount = 3, lineLength = threeStar *  6)
            TestScreen(starCount = 2, lineLength = twoStar *    6)
            TestScreen(starCount = 1, lineLength = oneStar *    6)

            Spacer(modifier = Modifier.height(16.dp))

        }
        Column {
            Column(modifier = Modifier.padding(top = 16.dp, start = 20.dp) ) {
                Text(text = "${fiveStar}",   fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp, top = 7.dp))
                Text(text = "${fourStar}",   fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "${threeStar}",  fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "${twoStar}",    fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "${oneStar}",    fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
            }
        }

    }

}

data class Review(
    val rating: Int,
    val time: String,
    val review: String,
    val photo: Int,
    val reviewNo: Int
)
val dummyReview = Review(
    rating = 5,
    time = "August 13, 2019", // This is just a dummy time, format it according to your needs
    photo = R.drawable.woman_top, // Replace 'your_drawable' with your actual drawable resource
    review =  "I loved this dress so much as soon as I tried it on I knew I had to buy it in another color. I am 5'3 about 155lbs and I carry all my weight in my upper body. When I put it on I felt like it thinned me put and I got so many compliments.",
    reviewNo = 5
)

@Composable
@Preview
fun RatingReviewsPreview(){
    Reviews( rating = 4.5, max = 5)
//    RatingReviews( navController = NavController(LocalContext.current))
}