// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.random.Random


@Composable
@Preview
fun App() {
    Row(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Card(elevation = 0.dp, shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(5.dp)) {
            Column(modifier = Modifier.fillMaxHeight().width(300.dp), horizontalAlignment = Alignment.Start) {
                Spacer(Modifier.size(10.dp))
                Branding("shop.png", "Shops")
                Spacer(modifier = Modifier.size(80.dp))
                LazyColumn {
                    val menuItems = listOf(
                        Item("dashboard.png", "Dashboard"),
                        Item("order.png", "Orders"),
                        Item("product.png", "Products"),
                        Item("analytic.png", "Sales Analytics"),
                        Item("customercare.png", "Customer Care"),
                        Item("shipment.png", "Shipment"),
                        Item("employee.png", "Employee")
                    )

                    items(menuItems) {
                        MenuItem(it.id, it.text)
                        Spacer(modifier = Modifier.size(30.dp))
                    }
                }
//                Spacer(modifier = Modifier.size(10.dp))
                Card(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                    }

                }

            }
        }
        Card(elevation = 0.dp, shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(5.dp)) {
            Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
                Spacer(modifier = Modifier.size(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth().height(60.dp)
                ) {
                    var searchValue by remember { mutableStateOf("") }

                    Text(text = "Dashboard", style = MaterialTheme.typography.h4, fontFamily = FontFamily.Monospace)
//
                    Card(
                        modifier = Modifier.fillMaxWidth(0.6f).fillMaxHeight(1.0f),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        TextField(
                            value = searchValue,
                            onValueChange = { searchValue = it },
                            placeholder = { Text(text = "Dashboard", fontFamily = FontFamily.Monospace) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource("search.png"), "", modifier = Modifier.size(60.dp)
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Transparent,
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                Color.Black, fontFamily = FontFamily.Monospace, fontSize = 20.sp
                            ),
//
                        )
                    }

                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        val listOfTopbarIcon =
                            listOf(TopBarIcon("mail.png"), TopBarIcon("notification.png"), TopBarIcon("person.png"))
                        items(listOfTopbarIcon) {
                            TopBarIcon(it.id) {

                            }
                            Spacer(Modifier.padding(10.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))

                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                    Column(
                        modifier = Modifier.fillMaxHeight().weight(0.7f).background(Color.White).padding(40.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            ProgressCard(0.8f, "Total Orders", 12344)
//                            Spacer(modifier = Modifier.size(10.dp))
                            ProgressCard(0.8f, "Total Sales", 24255)
//                            Spacer(modifier = Modifier.size(10.dp))
                            ProgressCard(0.8f, "Order Revenue", 7855)
//                            Spacer(modifier = Modifier.size(10.dp))
                            ProgressCard(0.8f, "Total Visitor", 45255)
                        }
                        Spacer(modifier = Modifier.size(20.dp))


                        Card(elevation = 10.dp, shape = RoundedCornerShape(10.dp)) {
                            Column {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Product Sales",
                                    style = MaterialTheme.typography.h4,
                                    fontFamily = FontFamily.Monospace,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Row() {
                                    LazyColumn(
                                        modifier = Modifier.weight(0.1f).height(300.dp),
                                        verticalArrangement = Arrangement.SpaceEvenly,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        items(8) {
                                            Text(
                                                text = "${it + 1}",
                                                style = MaterialTheme.typography.h6,
                                                fontFamily = FontFamily.Monospace
                                            )
                                        }
                                    }

                                    LazyRow(
                                        modifier = Modifier.weight(0.8f).background(Color.White),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        items(List(12) { Random.nextInt(100, 300) }) {
                                            GraphProgress(it.dp)
                                        }
                                    }
                                    Spacer(modifier = Modifier.weight(0.1f))
                                }


                                Spacer(
                                    modifier = Modifier.size(10.dp)
                                )
                                LazyRow(
                                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    items(
                                        listOf(
                                            "Jan",
                                            "Feb",
                                            "Mar",
                                            "Apr",
                                            "May",
                                            "Jun",
                                            "Jul",
                                            "Aug",
                                            "Sep",
                                            "Oct",
                                            "Nov",
                                            "Dec"
                                        )
                                    ) {
                                        Text(
                                            text = "$it",
                                            style = MaterialTheme.typography.h6,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    }
                                }

                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Column(
                        modifier = Modifier.fillMaxHeight().weight(0.3f).background(Color.White).padding(10.dp)
                    ) {

                    }
                }

            }
        }
    }
}


@Composable
fun GraphProgress(height: Dp) {

    Box {
        Box(
            modifier = Modifier.width(30.dp).height(300.dp).shadow(elevation = 10.dp, clip = true).clip(
                RoundedCornerShape(50.dp)
            ).background(Color.LightGray)
        )
        Box(
            modifier = Modifier.width(30.dp).height(if (height > 300.dp) 300.dp else height).clip(
                RoundedCornerShape(50.dp)
            ).background(brush = Brush.verticalGradient(listOf(Color.Magenta, Color.Cyan)), alpha = 0.7f)
        )
    }

}


@Composable
fun ProgressCard(progress: Float, title: String, orderValue: Int) {
    Card(elevation = 10.dp, shape = RoundedCornerShape(10.dp), modifier = Modifier.width(200.dp).height(300.dp)) {
        Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, style = MaterialTheme.typography.h6, fontFamily = FontFamily.Monospace)
            Text(text = "$orderValue$", style = MaterialTheme.typography.h6, fontFamily = FontFamily.Monospace)
            RoundedCircularProgress(
                progress = progress, strokeWidth = 30.dp, progressColor = Color.Black, modifier = Modifier.size(150.dp)
            )

        }
    }
}

@Composable
fun TopBarIcon(id: String, onClick: () -> Unit) {
    Card(elevation = 10.dp, shape = RoundedCornerShape(10.dp)) {
        IconButton(onClick = onClick) {
            Icon(painterResource(id), "")
        }

    }
}


@Composable
fun RoundedCircularProgress(
    progress: Float, strokeWidth: Dp, progressColor: Color, modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(200.dp), contentAlignment = Alignment.Center) {
        // circle progress
        CircularProgressIndicator(
            progress = progress, color = progressColor, strokeWidth = strokeWidth, modifier = Modifier.fillMaxSize()
        )
        // start circle
        Spacer(
            modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.TopCenter).size(strokeWidth)
                .background(progressColor, CircleShape)
        )
        // end circle
        Spacer(
            modifier = Modifier.fillMaxSize().rotate(360 * progress).wrapContentSize(align = Alignment.TopCenter)
                .size(strokeWidth).background(progressColor, CircleShape)
        )
    }
}


@Composable
fun Branding(id: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = painterResource(id), "", modifier = Modifier.weight(0.5f))
        Text(
            text = text,
            color = Color.Black,
            fontSize = 40.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.weight(1.0f)
        )
    }
}


@Composable
fun MenuItem(id: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = painterResource(id), "", modifier = Modifier.weight(0.5f))
        Text(
            text = text,
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1.0f)
        )
    }
}


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Dashboard",
        icon = painterResource("dashboardmain.png"),
    ) {
        App()
    }
}



