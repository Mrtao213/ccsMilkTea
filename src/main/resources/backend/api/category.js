const queryCategory = (params)=>{
    return $axios({
        url: '/category/page',
        method: 'get',
        params: params
    })
}

const queryAllCategory= ()=>{
    return $axios({
        url: '/category/queryAll',
        method: 'get',
    })
}

const queryCategoryById = (params)=>{
    return $axios({
        url: '/category/query',
        method: 'get',
        params: params
    })
}

const addCategory = (params)=>{
    return $axios({
        url: '/category/add',
        method: 'post',
        data: params
    })
}

const updateCategory = (params)=>{
    return $axios({
        url: '/category/update',
        method: 'put',
        data: params
    })
}

const deleteCategory = (params)=>{
    return $axios({
        url: '/category/delete',
        method: 'delete',
        params: params
    })
}