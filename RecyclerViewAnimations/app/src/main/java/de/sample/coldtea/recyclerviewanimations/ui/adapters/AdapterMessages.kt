package de.sample.coldtea.recyclerviewanimations.ui.adapters

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import de.sample.coldtea.recyclerviewanimations.model.TextData
import de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates.DelegateTextMessage

class AdapterMessages: ListDelegationAdapter<List<TextData>>(
    DelegateTextMessage()
)
