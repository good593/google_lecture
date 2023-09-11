import {createSlice, configureStore} from '@reduxjs/toolkit';

const counterSlice = createSlice({
  name: 'counter',
  initialState : {value: 0},
  reducers:{
    up:(state, action)=>{
      state.value = state.value + action.payload;
    },
    down:(state, action)=>{
      state.value = state.value - action.payload;
    }
  }
})

export default counterSlice;