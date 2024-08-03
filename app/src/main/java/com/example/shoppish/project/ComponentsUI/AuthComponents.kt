package com.example.shoppish.project.ComponentsUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.ui.theme.metropolisFamilyFont
import com.example.shoppish.ui.theme.poppinsFamilyFont

@Composable
fun NameTextField( labelValue : String,
                   onTextSelected: (String) -> Unit,
                   errorStatus : Boolean = false ){
    val nameValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = nameValue.value,
        onValueChange = { nameValue.value = it
                        onTextSelected(it)},
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier.fillMaxWidth(),
        leadingIcon ={
            Icon(Icons.Outlined.Person, contentDescription = "person")
        },
        singleLine = true,
        maxLines = 1,
        isError = !errorStatus

    )
}
@Composable
fun EmailTextField( labelValue : String,
                    onTextSelected: (String) -> Unit,
                    errorStatus : Boolean = false ){
    val emailValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = { emailValue.value = it
                        onTextSelected(it)},
        label = { Text(text = labelValue) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,imeAction = ImeAction.Next),
        leadingIcon ={
            Icon(Icons.Outlined.Email, contentDescription = "person")
        },
        singleLine = true,
        maxLines = 1,
        isError = !errorStatus

    )
}
@Composable
fun PasswordTextField( labelValue : String,
                       onTextSelected: (String) -> Unit,
                       errorStatus : Boolean = false ){
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it
                        onTextSelected(it)},
        label = { Text(text = labelValue) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,imeAction = ImeAction.Next),
        leadingIcon ={
            Icon(Icons.Outlined.Lock, contentDescription = "passowrd")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            }else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = "Password visibility")

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        isError = !errorStatus

    )
}
@Composable
fun CheckboxComponent(onCheckedChange : (Boolean) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp)
        .padding(top = 6.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,

        ){
        val checkedState = remember {
            mutableStateOf(false)
        }
        val boxColor = R.color.box_color
        val textColor = R.color.text_color
        Checkbox(checked = checkedState.value,
            onCheckedChange ={
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            } )
        Column {
            Row(
                modifier = Modifier.padding(start = 4.dp)
            ) {
                Text(
                    text = "By continuing you accept our ",
                    color = colorResource(id = textColor),
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    ),
                )

                Text(
                    text = "Privacy Policy", // Underlined text
                    color =  colorResource(id = textColor),
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontSize = 11.sp,
                        textDecoration = TextDecoration.Underline // Add underline decoration
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp) // Optional padding for separation
                )
                Text(
                    text =  " and",
                    color =  colorResource(id = textColor),
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    ),
                )

            }
            Spacer(modifier = Modifier.heightIn(5.dp))
            Row(
            ) {

                Text(
                    text = "Term of Use",
                    color =  colorResource(id = textColor),
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp) // Optional padding for separation
                )
            }
        }


    }
}
@Composable
fun ButtonComponent(  isEnabled : Boolean = false,
                      onButtonClicked : () -> Unit,
                      text : String
                      ){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(25.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
//                contentColor = colorResource(id = R.color.white)
        ),
        onClick = { onButtonClicked.invoke()  },
    )

    {
        Text(text = text,
            style = TextStyle(
                color = colorResource(id = R.color.white),
                fontFamily = poppinsFamilyFont,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
        )

    }
}


