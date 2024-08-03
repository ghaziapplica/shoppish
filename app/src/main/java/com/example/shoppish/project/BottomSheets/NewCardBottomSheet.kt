package com.example.shoppish.project.BottomSheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.project.tests.CreditCardFilter
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCardBottomSheet( ){
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var isCheckedd by remember { mutableStateOf(false) }

    // 1- Name TextField State
    var name by remember { mutableStateOf("") }


// 2- Card Number TextField State



// 3- Expiry Date TextField State


// 4- CVV TextField State
    var cvv by remember { mutableStateOf("") }
    var expiryNumber by remember { mutableStateOf("") }


    Column (
        modifier = Modifier
            .background(Color(0xFFF9F8F8))
            .padding(start = 16.dp, end = 16.dp, top = 20.dp)
    ){

        Text(text = "Add new card",
            style = TextStyle(
                fontFamily = metropolisFamilyFont,
                fontWeight = FontWeight.SemiBold,
                fontSize =  18.sp),
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )


        Spacer(modifier = Modifier.padding(top = 20.dp));



        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name on card",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE)// Set your desired color for unfocused state
            )
        )
        Spacer(modifier = Modifier.padding(top = 20.dp));


        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Card number",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = CreditCardFilter,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE)// Set your desired color for unfocused state
            ),

            trailingIcon = {
                val iconId = when {
                    cardNumber.text.startsWith("5") -> R.drawable.cardmaster
                    cardNumber.text.startsWith("3") -> R.drawable.visa
                    else -> 0 // Default or no icon
                }
                if (iconId != 0) {
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = "Card Icon"
                    )
                }
            }
        )

// Usage inside a Composable function for Card Number

                Spacer(modifier = Modifier.padding(top = 20.dp));

// Usage inside a Composable function for Expiry Date
        OutlinedTextField(
            value = expiryNumber,
            onValueChange = { newValue ->
                if (newValue.length <= 4 && newValue.all { it.isDigit() }) {
                    expiryNumber = newValue
                }
            },
            label = { Text("Expire Date",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE)// Set your desired color for unfocused state
            ),
        )

        Spacer(modifier = Modifier.padding(top = 20.dp));

// Usage inside a Composable function for CVV
        OutlinedTextField(
            value = cvv,
            onValueChange = { newValue ->
                if (newValue.length <= 3 && newValue.all { it.isDigit() }) {
                    cvv = newValue
                }
            },
            label = { Text("CVV",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE)// Set your desired color for unfocused state
            ),
        )

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 31.dp, start = 16.dp),
        ){
            Box (
                modifier = Modifier
                    .size(30.dp)
                    .padding(bottom = 5.dp)
            ){
                Checkbox(
                    checked = isCheckedd,
                    onCheckedChange = { isCheckedd = it },

                    )
            }

            Text(text = "Use as default payment method",
                fontFamily = metropolisFamilyFont,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top =  3.dp, start = 13.dp))

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, bottom = 28.dp),
            horizontalArrangement = Arrangement.Center

        ){
            androidx.compose.material.Button(
                onClick = { },
                modifier = Modifier
                    .size(width = 343.dp, height = 48.dp),
                shape = RoundedCornerShape(26.dp),
                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        0xFFDB3022
                    )
                ) // Use the orange color
            ) {
                Text(
                    text = "ADD CARD",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = metropolisFamilyFont
                )
            }

        }
    }
}
private val creditCardOffsetTranslator = object : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        if (offset <= 3) return offset
        if (offset <= 7) return offset + 1
        if (offset <= 11) return offset + 2
        if (offset <= 16) return offset + 3
        return 19
    }

    override fun transformedToOriginal(offset: Int): Int {
        if (offset <= 4) return offset
        if (offset <= 9) return offset - 1
        if (offset <= 14) return offset - 2
        if (offset <= 19) return offset - 3
        return 16
    }
}
val CreditCardFilter = VisualTransformation { text ->
    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i != 15) out += " "
    }
    TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}

@Composable
@Preview(showBackground = true)
fun NewCardBottomSheetPreview(){
    NewCardBottomSheet ( )
}