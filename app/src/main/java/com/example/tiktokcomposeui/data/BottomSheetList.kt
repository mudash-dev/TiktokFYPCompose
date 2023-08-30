package com.example.tiktokcomposeui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClosedCaption
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.HeartBroken


    val bottomSheetItems = listOf(
        BottomSheetItem(
            name = "Report",
            icon = Icons.Filled.Flag
        ),
        BottomSheetItem(
            name = "Not Interested",
            icon = Icons.Filled.HeartBroken
        ),
        BottomSheetItem(
            name = "Download",
            icon = Icons.Filled.Download
        ),
        BottomSheetItem(
            name = "Turn on captions",
            icon = Icons.Filled.ClosedCaption
        )
    )
