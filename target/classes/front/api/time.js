function formatDate(date, format = 'yyyy-MM-dd HH:mm:ss') {
    debugger
    let year = date.getFullYear();
    let month = String(date.getMonth() + 1).padStart(2, '0');
    let day = String(date.getDate()).padStart(2, '0');
    let hour = String(date.getHours()).padStart(2, '0');
    let minute = String(date.getMinutes()).padStart(2, '0');
    let second = String(date.getSeconds()).padStart(2, '0');

    let obj = {
        'M+': month, // 月份
        'd+': day, // 日
        'h+': hour, // 小时
        'm+': minute, // 分
        's+': second, // 秒
        'yyyy': year, // 年份
        'MM': month,
        'dd': day,
        'HH': hour,
        'mm': minute,
        'ss': second
    };

    format = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
 /*   for (let k in obj) {
        if (new RegExp(`(${k})`).test(format)) {
            format = format.replace(RegExp.$1, (RegExp.$1.length === 1) ? (obj[k]) : (('00' + obj[k]).substr(('' + obj[k]).length)));
        }
    }*/

    return format;
}
