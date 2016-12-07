String.prototype.format = function() {
	var placeholderREG = /\{(\d+)\}/g;
	var args = arguments;
	return this.replace(placeholderREG, function(holder, num) {
		return args[num];
	});
}
