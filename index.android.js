//This module is only for logging the ansers from fabric
'use strict';

var FabricAnswers = require('react-native').NativeModules.FabricAnswers;
var FAnswers = {
		logView(attributes) {
						FabricAnswers.logViewEvent(attributes)
				},
				customEvent(name, attributes) {
						FabricAnswers.logCustomEvent(name, attributes)
				}
}
module.exports = FAnswers;