import {createSlice, createAsyncThunk} from '@reduxjs/toolkit';

const asyncUpFetch = createAsyncThunk(
  'counterSlice/asyncUpFetch',
  async () => {
    const resp = await fetch('https://jsonplaceholder.typicode.com/todos/1')
    const data = await resp.json();
    console.log(data)
    return data;

  }
)

const counterAsyncSlice = createSlice({
  name:'counterSlice',
  initialState:{
    value:0,
    status:'Welcome'
  },
  reducers:{
    up:(state, action)=>{
      state.value = state.value + action.payload;
    }
  },
  extraReducers: (builder) => {
    builder.addCase(asyncUpFetch.pending, (state,action)=>{
      state.status = 'Loading';
    })
    builder.addCase(asyncUpFetch.fulfilled, (state,action)=>{
      state.value = action.payload['id'];
      state.status = 'complete';
    })
    builder.addCase(asyncUpFetch.rejected, (state,action)=>{
      state.status = 'fail';
    })
  }
});
export default counterAsyncSlice;
export {asyncUpFetch}

