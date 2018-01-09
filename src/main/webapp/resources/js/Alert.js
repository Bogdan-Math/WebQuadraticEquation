function Alert(text) {
    this.text = text;

    this.info = function () {
        alert('info');
    };

    this.warning = function () {
        alert('warning');
    };

    this.error = function () {
        alert('danger');
    };

    this.success = function () {
        alert('success');
    };

    var me    = this,
        alert = function (type) {
        $.notify({message: me.text},
            {
                type: type,
                placement: {
                    from : "bottom",
                    align: "right"
                }
            }
        );
    };
}