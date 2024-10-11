const queryEmployee = (params)=>{
    return $axios({
        url: '/employee/page',
        method: 'get',
        params: params
    })
}

const queryEmployeeById = (params)=>{
    return $axios({
        url: '/employee/query',
        method: 'get',
        params: params
    })
}

const addEmployee = (params)=>{
    return $axios({
        url: '/employee/add',
        method: 'post',
        data: params
    })
}

const updateEmployee = (params)=>{
    return $axios({
        url: '/employee/update',
        method: 'put',
        data: params
    })
}

const deleteEmployee = (params)=>{
    return $axios({
        url: '/employee/delete',
        method: 'delete',
        params: params
    })
}

const batchDeleteEmployee = (params)=>{
    return $axios({
        url: '/employee/batchDelete',
        method: 'delete',
        data: params
    })
}