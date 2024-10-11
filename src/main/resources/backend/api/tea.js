// 查询茶品列表
const getTeaPage = (params)=>{
    return $axios({
        url: '/tea/page',
        method: 'get',
        params
    })
}

// 新增茶品
const addTea = (params)=>{
    return $axios({
        url: '/tea/add',
        method: 'post',
        data: {...params}
    })
}

// 根据id查询茶品
const queryTeaById = (params)=>{
    return $axios({
        url: '/tea/query',
        method: 'get',
        params: params
    })
}

// 修改茶品
const updateTea = (params)=>{
    return $axios({
        url: '/tea/update',
        method: 'put',
        data: params
    })
}

// 删除茶品
const deleteTea = (id)=>{
    return $axios({
        url: '/tea/delete',
        method: 'delete',
        params: id
    })
}
const batchDeleteTea = (params)=>{
    return $axios({
        url: '/tea/batchDelete',
        method: 'delete',
        data: params
    })
}
// 批量删除茶品
