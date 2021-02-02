package com.example.priori_t;

import androidx.lifecycle.ViewModelProvider;

public class SingletonTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    /*Viewmodelprovider(this) retains viewModelStore bound to THIS  ViewModelStore -> this
    * Different activities have different ViewModelStores, where each ViewModelStore creates a different
    * instance of a ViewModel using a given factory*/

    /* So the solution here is to create a singleton factory which will pass the same instance of my
    *  viewmodel between different activities*/
    TaskViewModel vm;
    public SingletonTaskViewModelFactory() {

    }
}
