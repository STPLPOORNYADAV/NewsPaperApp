package com.example.newpaperapp.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newpaperapp.ui.theme.themecolor
import com.example.newpaperapp.ui.theme.viewmodel.NewspaperDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewspaperDetailScreen(
    url: String,
    viewModel: NewspaperDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(url) {
        viewModel.fetchNewspaperDetail(url)
    }

    val newspaperDetail by viewModel.newspaperDetail.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Newspaper Details", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = themecolor,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            newspaperDetail?.let { detail ->

                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFCCBC)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = detail.name.replace("[volume]", "").trim(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFBF360C)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Published by: ${detail.publisher}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))


                        Text(
                            text = "Location: ${detail.placeOfPublication}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))


                        Text(
                            text = "Years Active: ${detail.startYear} - ${detail.endYear}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF3E2723)
                        )




                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }





            } ?: CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
