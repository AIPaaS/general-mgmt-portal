var storage, fail, uid;
try {
	uid = new Date;
	(storage = window.localStorage).setItem(uid, uid);
	fail = storage.getItem(uid) != uid;
	storage.removeItem(uid);
	fail && (storage = false);
} catch (e) {
}
if (storage) {
	try {
		var usedSkin = localStorage.getItem('config-skin');
		if (usedSkin != '' && usedSkin != null) {
			 $("body").attr("class",usedSkin);
		} else {
			$("body").attr("class",'theme-whbl');
		}
	} catch (e) {
		$("body").attr("class",'theme-whbl');
	}
} else {
	$("body").attr("class",'theme-whbl');
}
