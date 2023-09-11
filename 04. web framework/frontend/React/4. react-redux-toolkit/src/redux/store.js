import {createSlice, configureStore} from '@reduxjs/toolkit';
import counterSlice from './counterSlice';
import counterAsyncSlice from './counterAsyncSlice'

const store = configureStore({
  reducer:{
    counter:counterSlice.reducer,
    counterAsync:counterAsyncSlice.reducer
  }
})

export default store;