let showAlert = function (type, text) {
    $.notify({message: text},
        {
            type: type,
            placement: {
                from : "bottom",
                align: "right"
            }
        }
    );
};