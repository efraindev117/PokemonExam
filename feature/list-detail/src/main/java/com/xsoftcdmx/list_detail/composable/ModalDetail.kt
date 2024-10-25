package com.xsoftcdmx.list_detail.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.xsoft.pokemonexam.core.model.PokemonDetail
import java.util.Locale


@Composable
fun ModalBottomSheetContent(
    modifier: Modifier = Modifier,
    titleColor: Color,
    itemData: PokemonDetail,
) {
    val emoji = getPokemonTypeEmoji(itemData.types?.first()?.type?.name)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        Text(
            text = itemData.name!!.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            },
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold, color = titleColor
        )

        Text(
            text = "Altura: ${convertHeightToMeters(itemData.height!!)}",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Peso: ${convertWeightToKilograms(itemData.weight!!)}",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Tipo: $emoji ${itemData.types?.first()?.type?.name?.capitalize()}",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )

    }
}