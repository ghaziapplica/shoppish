package com.example.shoppish.project.BottomSheets

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppish.project.RatingSheet


@Composable
@Preview(showBackground = true)
fun RatingSheetPreview(){
    RatingSheet( isSelected = true)
}












//@Composable
//fun Star(isSelected: Boolean, onClick: () -> Unit) {
//    val image = if (isSelected) {
//        painterResource(id = R.drawable.full_star)
//    } else {
//        painterResource(id = R.drawable.star_empty)
//    }
//
//    Image(
//        painter = image,
//        contentDescription = null,
//        modifier = Modifier
//            .height(38.dp)
//            .width(38.dp)
//            .clickable(onClick = onClick)
//    )
//}
//
//@Composable
//fun StarRow() {
//    var selectedStars by remember { mutableStateOf(0) }
//
//    Row {
//        for (i in 1..5) {
//            Star(isSelected = i <= selectedStars) {
//                selectedStars = i
//            }
//        }
//    }
//}