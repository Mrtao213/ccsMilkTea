const getOrderPage = (params)=>{
    return $axios({
        url: '/order/page',
        method: 'get',
        params
    })
}

const addOrder = (params)=>{
    return $axios({
        url: '/order/page',
        method: 'post',
        params: {params}
    })
}

const queryOrder = (params)=>{
    return $axios({
        url: '/order/page',
        method: 'get',
        params
    })
}

const deleteOrder = (params)=>{
    return $axios({
        url: '/order/delete',
        method: 'delete',
        params
    })
}

const batchDeleteOrder = (params)=>{
    return $axios({
        url: '/order/batchDelete',
        method: 'delete',
        data: params
    })
}

const updateOrder = (params)=>{
    return $axios({
        url: '/order/page',
        method: 'get',
        params
    })
}

