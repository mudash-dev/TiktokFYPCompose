package com.example.tiktokcomposeui.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Forward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tiktokcomposeui.data.bottomNavItems
import com.example.tiktokcomposeui.data.bottomSheetItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForYouPageScreen() {

    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
           TopAppBar(
               title = { 
                   Text(text = "For You", textDecoration = TextDecoration.Underline, fontWeight = FontWeight.SemiBold)
               },
               actions = {
                   Icon(
                       imageVector = Icons.Filled.Notifications,
                       contentDescription = "Notification Icon",
                       modifier = Modifier
                           .padding(8.dp)
                           .clickable {
                               TODO(
                                   "Allow user to receive and view " +
                                           "notifications eg: newly uploaded content"
                               )
                           }
                   )
                   Icon(
                       imageVector = Icons.Outlined.Search,
                       contentDescription = "Search Icon",
                       modifier = Modifier
                           .padding(8.dp)
                           .clickable { TODO("Allow user to perform search action") }
                   )
               },
               colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
           )

        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                bottomNavItems.forEach { item ->
                    val selected = item.route == backStackEntry.value?.destination?.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = { navController.navigate(item.route) },
                        label = {
                                Text(text = item.name, fontWeight = FontWeight.SemiBold)
                        },
                        icon = { 
                            Icon(imageVector = item.icon, contentDescription = "${item.name} Icon")
                        }
                    )
                }
            }


        }
        
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            SmallFloatingActionButton(onClick = { TODO("Allow user to follow owner of the displayed " +
                    "content only if user has an account") }) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Add to follow list")
            }
            Spacer(modifier = Modifier.height(8.dp))
            SmallFloatingActionButton(onClick = { TODO("Like content and display the count " +
                    "icon") }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Like content")
            }
            Spacer(modifier = Modifier.height(8.dp))
            SmallFloatingActionButton(onClick = { TODO("See comment section") }) {
                Icon(imageVector = Icons.Filled.Comment, contentDescription = "Comment on content")
            }
            Spacer(modifier = Modifier.height(8.dp))
            SmallFloatingActionButton(onClick = { TODO("add content to saved/bookmark file") }) {
                Icon(imageVector = Icons.Filled.Bookmark, contentDescription = "Bookmark content")
            }

            Spacer(modifier = Modifier.height(8.dp))
            SmallFloatingActionButton(onClick =  {
                    showSheet = true

            } ) {
                Icon(imageVector = Icons.Filled.Forward, contentDescription = "Forward content")
            }
            if (showSheet){
                SeeBottomSheet()
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeeBottomSheet() {
    val sheetState = rememberModalBottomSheetState( skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(false) }

    ModalBottomSheet(
        onDismissRequest = {
               showSheet = false
        },
        sheetState = sheetState,
        shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
        dragHandle = {
            Spacer(modifier = Modifier
                .width(30.dp)
                .height(5.dp)
                .background(Color.Black))
        }
    ) {
        BottomSheetContainer()
    }
}

@Composable
fun BottomSheetContainer() {
    Column {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "Share to", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Text(text = "Implement the Android Sharesheet feature here...")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Divider(color = Color.Black, thickness = 1.dp)
        Box {
            Column(
                modifier = Modifier.padding(10.dp),
            ) {
                bottomSheetItems.forEach { item ->
                    Row {
                    Icon(imageVector = item.icon, contentDescription = "${item.name} Icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = item.name, fontWeight = FontWeight.SemiBold)
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun SeeScreen() {
    Column {
        ForYouPageScreen()
    }

}