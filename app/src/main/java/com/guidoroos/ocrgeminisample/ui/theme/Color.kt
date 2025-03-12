package com.guidoroos.ocrgeminisample.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CustomColors(

    //alerts
    val alertMessage: Color,
    val alertButtonText: Color,
    val alertTitleInfo: Color,
    val alertTitleWarning: Color,
    val alertTitleError: Color,

    //background
    val defaultBackground: Color,
    val secondaryBackground: Color,
    val tertiaryBackground: Color,
    val emptyStateBackground: Color,
    val variantBackground: Color,

    //appBar
    val appBarText: Color,
    val appBarTextSelected: Color,
    val appBarBackground: Color,
    val appBarIconVariant: Color,
    val appBarIcon: Color,

    //button
    val primaryButtonColor: Color,
    val secondaryButtonColor: Color,
    val tertiaryButtonColor: Color,
    val cancelButtonColor: Color,
    val primaryButtonTextColor: Color,
    val secondaryButtonTextColor: Color,
    val tertiaryButtonTextColor: Color,
    val cancelButtonTextColor: Color,

    //checkbox
    val checkBoxBackground: Color,
    val checkBoxBackgroundChecked: Color,
    val checkBoxBackgroundCheckedOnCard: Color,
    val checkBoxContent: Color,

    //card
    val cardBackground: Color,
    val cardBackgroundVariant: Color,
    val cardBackgroundDisabled: Color,
    val cardContent: Color,
    val cardContentDisabled: Color,
    val cardVerticalLine: Color,
    val secondaryCardBackground: Color,
    val secondaryCardContent: Color,

    //list
    val divider: Color,

    //loading
    val loadingIndicator: Color,

    //bottomsheet
    val bottomsheetCancelIcon: Color,
    val bottomsheetApproveIcon: Color,
    val bottomSheetTextLabelColor: Color,

    //icon
    val icon: Color,
    val iconLight: Color,
    val iconSelected: Color,
    val iconBackground: Color,
    val iconErrorBackground: Color,
    val iconGrey: Color,
    val placeholderImage: Color,
    val deleteIcon: Color,

    //textField
    val textFieldBackground: Color,
    val textFieldText: Color,
    val textFieldTextGrey: Color,
    val textFieldCursor: Color,
    val textFieldBorder: Color,
    val invertedTextFieldBackground: Color,
    val invertedTextFieldText: Color,
    val invertedTextFieldTextVariant: Color,
    val textFieldVariant: Color,
    val textDisabled: Color,
    val searchFieldBackground: Color,

    //text
    val textHeader: Color,
    val textDefault: Color,
    val textAccent: Color,
    val textSub: Color,
    val textInputBackground: Color,
    val textInputText: Color,

    //dropdown
    val dropDownIcon: Color,
    val dropDownText: Color,
    val dropDownBackground: Color,

    //progressbar
    val progressBar: Color,
    val progressBarBackground: Color,
)

data class ColorSet(
    val customColors: CustomColors = CustomColors(
        //alert
        alertMessage = ColorGrey800,
        alertButtonText = ColorGrey100,

        alertTitleInfo = ColorGrey700,
        alertTitleWarning = ColorWarning700,
        alertTitleError = ColorError700,

        //appbar
        appBarText = ColorGrey200,
        appBarTextSelected = ColorVariant200,
        appBarBackground = ColorPrimary700,
        appBarIcon = ColorGrey200,
        appBarIconVariant = ColorVariant200,

        //background
        defaultBackground = ColorGrey100,
        secondaryBackground = ColorGrey300,
        tertiaryBackground = ColorPrimary100,
        emptyStateBackground = ColorGrey100,
        variantBackground = ColorVariant300,

        //button
        primaryButtonColor = ColorVariant700,
        secondaryButtonColor = ColorPrimary600,
        tertiaryButtonColor = ColorVariant500,
        cancelButtonColor = ColorError600,
        primaryButtonTextColor = ColorGrey100,
        secondaryButtonTextColor = ColorGrey100,
        tertiaryButtonTextColor = ColorGrey100,
        cancelButtonTextColor = ColorGrey100,

        //checkbox
        checkBoxBackground = ColorGrey600,
        checkBoxBackgroundChecked = ColorVariant200,
        checkBoxBackgroundCheckedOnCard = ColorPrimary200,
        checkBoxContent = ColorGrey700,

        //card
        cardBackground = ColorVariant100,
        cardBackgroundVariant = ColorPrimary600,
        cardBackgroundDisabled = ColorGrey200,
        cardContent = ColorGrey800,
        cardContentDisabled = ColorGrey800,
        cardVerticalLine = ColorVariant500,
        secondaryCardBackground = ColorPrimary700,
        secondaryCardContent = ColorGrey100,

        //list
        divider = ColorGrey300,

        //loading
        loadingIndicator = ColorVariant700,

        //bottomsheet
        bottomsheetCancelIcon = ColorError500,
        bottomsheetApproveIcon = ColorSuccess500,
        bottomSheetTextLabelColor = ColorGrey800,

        //icon
        placeholderImage = ColorGrey700,
        icon = ColorGrey800,
        iconLight = ColorGrey300,
        iconSelected = ColorVariant600,
        iconBackground = ColorVariant400,
        iconGrey = ColorGrey700,
        iconErrorBackground = ColorError300,
        deleteIcon = ColorError600,

        //textfield
        textFieldBackground = ColorGrey200,
        textFieldText = ColorGrey800,
        textFieldTextGrey = ColorGrey500,
        textFieldCursor = ColorVariant700,
        textFieldBorder = ColorVariant800,
        textFieldVariant = ColorVariant700,
        textDisabled = ColorGrey500,
        searchFieldBackground = ColorGrey300,

        //invertedTextField
        invertedTextFieldBackground = ColorPrimary700,
        invertedTextFieldText = ColorGrey100,
        invertedTextFieldTextVariant = ColorVariant300,

        //text
        textHeader = ColorVariant800,
        textDefault = ColorGrey800,
        textSub = ColorGrey600,
        textAccent = ColorPrimary500,
        textInputBackground = ColorPrimary200,
        textInputText = ColorGrey700,

        //dropDown
        dropDownIcon = ColorVariant700,
        dropDownText = ColorVariant800,
        dropDownBackground = ColorPrimary100,

        //progressbar
        progressBar = ColorPrimary500,
        progressBarBackground = ColorGrey300,

    )
)


// ColorPrimary (10 variants)
val ColorPrimary100 = Color.hsl(125f, 0.60f, 0.95f)
val ColorPrimary200 = Color.hsl(118f, 0.55f, 0.80f)
val ColorPrimary300 = Color.hsl(110f, 0.50f, 0.70f)
val ColorPrimary400 = Color.hsl(105f, 0.45f, 0.60f)
val ColorPrimary500 = Color.hsl(101f, 0.50f, 0.45f)
val ColorPrimary600 = Color.hsl(98f, 0.70f, 0.20f)
val ColorPrimary700 = Color.hsl(95f, 0.85f, 0.08f)
val ColorPrimary800 = Color.hsl(90f, 0.90f, 0.05f)

// ColorGrey (10 variants)
val ColorGrey100 = Color.hsl(118f, 0.16f, 0.99f)
val ColorGrey200 = Color.hsl(116f, 0.12f, 0.96f)
val ColorGrey300 = Color.hsl(113f, 0.10f, 0.80f)
val ColorGrey400 = Color.hsl(110f, 0.07f, 0.55f)
val ColorGrey500 = Color.hsl(107f, 0.10f, 0.45f)
val ColorGrey600 = Color.hsl(104f, 0.11f, 0.35f)
val ColorGrey700 = Color.hsl(102f, 0.12f, 0.20f)
val ColorGrey800 = Color.hsl(100f, 0.13f, 0.05f)

// ColorVariant (10 variants)
val ColorVariant100 = Color.hsl(325f, 0.88f, 0.98f)
val ColorVariant200 = Color.hsl(334f, 0.80f, 0.92f)
val ColorVariant300 = Color.hsl(337f, 0.68f, 0.85f)
val ColorVariant400 = Color.hsl(338f, 0.65f, 0.60f)
val ColorVariant500 = Color.hsl(340f, 0.60f, 0.45f)
val ColorVariant600 = Color.hsl(330f, 0.65f, 0.40f)
val ColorVariant700 = Color.hsl(325f, 0.70f, 0.20f)
val ColorVariant800 = Color.hsl(320f, 0.80f, 0.10f)

// ColorError (10 variants)
val ColorError100 = Color.hsl(15f, 0.80f, 0.90f)
val ColorError200 = Color.hsl(12f, 0.75f, 0.80f)
val ColorError300 = Color.hsl(10f, 0.70f, 0.70f)
val ColorError400 = Color.hsl(8f, 0.62f, 0.55f)
val ColorError500 = Color.hsl(8f, 0.62f, 0.45f)
val ColorError600 = Color.hsl(7f, 0.65f, 0.35f)
val ColorError700 = Color.hsl(6f, 0.75f, 0.25f)
val ColorError800 = Color.hsl(5f, 0.80f, 0.15f)

// ColorWarning (10 variants)
val ColorWarning100 = Color.hsl(57f, 0.85f, 0.85f)
val ColorWarning200 = Color.hsl(54f, 0.80f, 0.75f)
val ColorWarning300 = Color.hsl(52f, 0.77f, 0.65f)
val ColorWarning400 = Color.hsl(50f, 0.72f, 0.55f)
val ColorWarning500 = Color.hsl(50f, 0.72f, 0.45f)
val ColorWarning600 = Color.hsl(49f, 0.75f, 0.35f)
val ColorWarning700 = Color.hsl(48f, 0.80f, 0.25f)
val ColorWarning800 = Color.hsl(46f, 0.82f, 0.15f)

// ColorSuccess (10 variants)
val ColorSuccess100 = Color.hsl(94f, 0.80f, 0.85f)
val ColorSuccess200 = Color.hsl(96f, 0.75f, 0.75f)
val ColorSuccess300 = Color.hsl(98f, 0.70f, 0.65f)
val ColorSuccess400 = Color.hsl(100f, 0.62f, 0.50f)
val ColorSuccess500 = Color.hsl(100f, 0.62f, 0.40f)
val ColorSuccess600 = Color.hsl(101f, 0.65f, 0.30f)
val ColorSuccess700 = Color.hsl(102f, 0.70f, 0.20f)
val ColorSuccess800 = Color.hsl(104f, 0.75f, 0.10f)


@Composable
fun ColorPreview(colors: List<Color>) {
    LazyRow(
        content = {
            items(colors) { color ->
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color),
                )
            }
        }
    )
}

@Composable
@Preview
fun ColorPreviews() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Color Primary", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorPrimary100,
                ColorPrimary200,
                ColorPrimary300,
                ColorPrimary400,
                ColorPrimary500,
                ColorPrimary600,
                ColorPrimary700,
                ColorPrimary800
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Color Grey", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorGrey100,
                ColorGrey200,
                ColorGrey300,
                ColorGrey400,
                ColorGrey500,
                ColorGrey600,
                ColorGrey700,
                ColorGrey800
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Color Variant", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorVariant100,
                ColorVariant200,
                ColorVariant300,
                ColorVariant400,
                ColorVariant500,
                ColorVariant600,
                ColorVariant700,
                ColorVariant800
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Error Colors", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorError100,
                ColorError200,
                ColorError300,
                ColorError400,
                ColorError500,
                ColorError600,
                ColorError700,
                ColorError800
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Warning Colors", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorWarning100,
                ColorWarning200,
                ColorWarning300,
                ColorWarning400,
                ColorWarning500,
                ColorWarning600,
                ColorWarning700,
                ColorWarning800
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Success Colors", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPreview(
            listOf(
                ColorSuccess100,
                ColorSuccess200,
                ColorSuccess300,
                ColorSuccess400,
                ColorSuccess500,
                ColorSuccess600,
                ColorSuccess700,
                ColorSuccess800
            )
        )
    }
}
