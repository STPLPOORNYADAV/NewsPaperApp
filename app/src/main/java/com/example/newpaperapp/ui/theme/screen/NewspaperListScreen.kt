package com.example.newpaperapp.ui.theme.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newpaperapp.R
import com.example.newpaperapp.data.model.NewspaperItem
import com.example.newpaperapp.ui.theme.themecolor
import com.example.newpaperapp.ui.theme.viewmodel.NewspaperListViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewspaperListScreen(
    navController: NavController,
    viewModel: NewspaperListViewModel = viewModel(),
    onItemClick: (NewspaperItem) -> Unit
) {
    val newspapers = viewModel.newspapers.collectAsState().value
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = themecolor)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Newspaper List", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = themecolor,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(newspapers) { newspaper ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFF8A80)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .clickable {
                            val encodedUrl = URLEncoder.encode(newspaper.url, StandardCharsets.UTF_8.toString())
                            navController.navigate("detail/$encodedUrl")
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.news_logo),
                            contentDescription = "Newspaper",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = newspaper.title.replace("[volume]", "").trim(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = newspaper.state,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}



