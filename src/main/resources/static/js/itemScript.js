
$(function () {
    $("#item-name").autocomplete({
        source: ["Laptop", "Mouse Pad", "Monitor"],
        minLength: 2
    });
});
