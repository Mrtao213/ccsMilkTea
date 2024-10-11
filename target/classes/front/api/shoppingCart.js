const queryCart = (params)=>{
    return $axios({
        url: '/cart/query',
        method: 'get',
        params: params
    })
}

const addGoods = (params)=>{
    return $axios({
        url: '/cart/add',
        method: 'post',
        data: params
    })
}

const clearCart = (params)=>{
    return $axios({
        url: '/cart/delete',
        method: 'delete',
        params: params
    })
}