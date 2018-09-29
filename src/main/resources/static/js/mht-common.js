/**
 * mht common js
 * @Author mht
 */

/**
 * ajax
 * @param url
 * @param param
 * @param callback
 * @param sync
 */
function ajaxGet(url,param,callback,sync) {
    $.ajax({
        url:url,
        type:'get',
        data:param,
        dataType:'json',
        async:sync ? true:false,
        success: function (response) {
            if(callback){
                callback(response);
            }
        },
        error: function (data, status, e){
            alert("操作失败，请联系mlh协助处理");
        }
    });
}

/**
 * ajax
 * @param url
 * @param param
 * @param callback
 * @param sync
 */
function ajaxPost(url,param,callback,sync) {
    $.ajax({
        url:url,
        type:'post',
        data:param,
        dataType:'json',
        async:sync ? true:false,
        success: function (response) {
            if(callback){
                callback(response);
            }
        },
        error: function (data, status, e){
            alert("操作失败，请联系mlh协助处理");
        }
    });
}
