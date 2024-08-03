import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.shoppish.project.BottomSheets.PasswordSheet
import com.example.shoppish.project.BottomSheets.PromoCodeSheet
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings() {
    var textFieldValue by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                PasswordSheet()
            }
        }
    }
Box (
    modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF9F9F9))
) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF9F9F9))
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }

            IconButton(onClick = {  },
                modifier = Modifier.padding(top = 10.dp)) {
                Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.Black)
            }

        }
        Text(
            text = "Settings",
            style = TextStyle(
                fontFamily = metropolisFamilyFont,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            ),
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Personal Information",
            style = TextStyle(
                fontFamily = metropolisFamilyFont,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { newValue -> textFieldValue = newValue },
            label = { Text("Full name",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { newValue -> textFieldValue = newValue },
            label = { Text("Date of birth",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
            )
        )
        Spacer(modifier = Modifier.height(54.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Password",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Change",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
                    .clickable { isSheetOpen = true }
            )
        }
        Spacer(modifier = Modifier.height(21.dp))

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { newValue -> textFieldValue = newValue },
            label = { Text("Password",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Set your desired color for focused state
                unfocusedBorderColor = Color(0xFFF9F8F8),
                containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
            )
        )
        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "Notifications",
            style = TextStyle(
                fontFamily = metropolisFamilyFont,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Sales",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomSwitch(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "New arrivals",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomSwitch(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery status changes",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomSwitch(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }

    }
}


}

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val switchWidth = 32.dp
    val switchHeight = 20.dp
    val thumbSize = 20.dp
    val thumbColor = Color(0xFF2AA952) // Green color

    val switchColors = androidx.compose.material3.SwitchDefaults.colors(
        checkedThumbColor = thumbColor,
        uncheckedThumbColor = Color.Gray,
        checkedTrackColor = Color.LightGray,
        uncheckedTrackColor = Color.LightGray
    )

    androidx.compose.material3.Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = Modifier
            .width(switchWidth)
            .height(switchHeight),
        colors = switchColors
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    Settings()
}
