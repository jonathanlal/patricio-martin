
<script src="/vendors/photoswipe/photoswipe.min.js"></script>
<script src="/vendors/photoswipe/photoswipe-ui-default.min.js"></script>
<link rel="stylesheet" href="/vendors/photoswipe/photoswipe.css">
<link rel="stylesheet" href="/vendors/photoswipe/default-skin.css">


    <link media="screen,projection" rel="stylesheet" type="text/css" href="/vendors/imgrid/css/imgrid.min.css">
    <link media="screen,projection" rel="stylesheet" type="text/css" href="/vendors/imgrid/css/imgrid.hover.min.css">
    
<style>
	@media all and (min-width : 768px) and (max-width : 1363px)  { .single-thumbnail {width: 180px !important; height: 120px !important;}}
	.pswp__minis-list{left: 0 !important;}
	.single-purchase{top: -30px !important;} 
	/* image gallery stuff */
	.rowg{display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;padding:0 4px}.columng{-ms-flex:25%;flex:25%;max-width:25%;padding:0 4px}.columng img{margin-top:8px;vertical-align:middle}@media screen and (max-width:800px){.columng{-ms-flex:50%;flex:50%;max-width:50%}}@media screen and (max-width:600px){.column{-ms-flex:100%;flex:100%;max-width:100%}}
</style>

<fmt:bundle basename = "text" prefix = "${project}.">

<section class="single-hero">
  <div class="single-hero-nav"><%@ include file="includes/nav.jsp"%></div>
  <div class="single-hero-image-container">
    <div class="single-hero-image">
      <a class="psw-item"><img src="<fmt:message key="hero.cover"/>" width="2880" height="1920" data-index="0"></a>    
    </div>
  </div>
  <div class="single-hero-gradient"></div>
</section>

<header class="single-header">
	<div class="container">
		<div class="single-columns">
			<div class="single-column is-head">
				<div class="single-thumbnails">
					<div class="single-thumbnails-list">
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image1"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image2"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					  <a class="single-thumbnail psw-item"><img src="<fmt:message key="hero.image3"/>" style="width:100%;height:auto;min-height: 150px;"></a>
					</div>
					<div class="single-thumbnails-action">
					  <button class="button is-info  is-small psw-trigger" href=""><span class="button-text" style="margin-top: -5px;"><fmt:message key="btn.photos"/></span></button>
					</div>
				</div>
				<div class="single-heading">
				  <h1 class="title single-heading-title" style="color:black !important;"><fmt:message key="title"/></h1>
				  <h2 class="location single-heading-location"><fmt:message key="subtitle"/></h2>
<%-- 				 <%@ include file="WEB-INF/templates/pattern.jsp" %> --%>
				  <div class="single-heading-introduction"><fmt:message key="lead-paragraph"/></div>
				  <div class="single-metas">
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.region"/></p>   
					  <p class="single-meta-link"><strong><fmt:message key="details.region.value"/></strong></p>    
					</div>
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.city"/></p>
					  <p class="single-meta-link"><strong><fmt:message key="details.city.value"/></strong></p>    
					</div>
				    <div class="single-meta">
				      <p class="single-meta-label"><fmt:message key="details.type"/></p>
					  <p class="single-meta-link"><a href="#"><fmt:message key="details.type.value"/></a></p>    
					</div>
				  </div>
				</div>
			</div>
			<div class="single-column is-meta">
				<div class="single-purchase">
					<div class="single-purchase-action">
						<img src='<fmt:message key="hero.website"/>' style="margin: 0 auto !important;display: flex;margin-bottom: 20px !important;">
						<a class="button is-info" href="<fmt:message key="website"/>" target="_blank">
						<span class="button-text"><strong><fmt:message key="btn.website"/></strong>&nbsp;<i class="fas fa-long-arrow-alt-right" style="margin-bottom:-2px !important;"></i></span>
						</a>
					</div>
				</div>
				<div class="single-stats">
					<div class="list-stats">
				      	<div class="stat">
				      		<strong class="stat-value"><fmt:message key="details.golf.value"/></strong>
				      		<em class="stat-label"><fmt:message key="details.golf"/></em>
						</div>
						<div class="stat">
				    		<strong class="stat-value"><fmt:message key="details.hectars.value"/></strong>
				    		<em class="stat-label"><fmt:message key="details.hectars"/></em>
						</div>
						<div class="stat">
							<strong class="stat-value"><fmt:message key="details.units.value"/></strong>
							<em class="stat-label"><fmt:message key="details.units"/></em>
						</div>
						<div class="stat">
							<strong class="stat-value"><fmt:message key="details.restaurants.value"/></strong>
							<em class="stat-label"><fmt:message key="details.restaurants"/></em>
						</div>
						
				  </div>
				</div>
			</div>
        </div>
	</div>
</header>

<section class="single-main">
	<div class="container">
		<div class="single-columns">
			<div class="single-column is-lead">
				<div class="single-content content"><p><fmt:message key="description"/></p></div>
				
				
				
				
				
				              <div class="imgrid"> 
				              
				              
				              <c:forEach items="${dd_photos}" var="img">
				              
				 <figure><img src="${img}">
                  <figcaption>
                    <p><a href="${img}" download><span class="icon-download icons-gallery"></span></a> <a href="#"><span class="icon-eye icons-gallery"></span></a></p>
                  </figcaption>
                </figure>
				              
				              </c:forEach>
				              
				              
				</div>
				
				
				
				
            	<div class="single-grid" style="margin: 0 auto !important;">
<!-- 					<div class="rowg" >  -->
<!-- 					  <div class="columng"> -->
<%-- 					    <img src="<fmt:message key="mason.1"/>" style="width:100%"> --%>
<%-- 					    <img src="<fmt:message key="mason.2"/>" style="width:100%"> --%>
<!-- 					  </div> -->
<!-- 					  <div class="columng"> -->
<%-- 					    <img src="<fmt:message key="mason.3"/>" style="width:100%"> --%>
<%-- 					    <img src="<fmt:message key="mason.4"/>" style="width:100%"> --%>
<!-- 					  </div>   -->
<!-- 					  <div class="columng"> -->
<%-- 					    <img src="<fmt:message key="mason.5"/>" style="width:100%"> --%>
<%-- 					    <img src="<fmt:message key="mason.6"/>" style="width:100%"> --%>
<!-- 					  </div> -->
<!-- 					    <div class="columng"> -->
<%-- 					    <img src="<fmt:message key="mason.7"/>" style="width:100%"> --%>
<%-- 					 	<img src="<fmt:message key="mason.8"/>" style="width:100%"> --%>
<!-- 					  </div> -->
<!-- 					</div> -->
				    <div class="single-grid-action">
				      <a class="button is-info  psw-trigger" href=""><span class="button-text"><fmt:message key="btn.photos"/></span></a>
				    </div>
				</div>
			</div>
		</div>
	</div>
</section>
</fmt:bundle>
    
<!-- photoswipe stuff -->
<script type="text/javascript">${photos}</script>
<%-- <jsp:include page="WEB-INF/templates/photoswipe.jsp"></jsp:include> --%>
<%@ include file="WEB-INF/templates/photoswipe.jsp" %>


<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<!--   <script src="/vendors/imgrid/js/imagesloaded.pkgd.js"></script> -->

<script>

(function () {
	

	/**
	 * Class for managing events.
	 * Can be extended to provide event functionality in other classes.
	 *
	 * @class EventEmitter Manages event registering and emitting.
	 */
	function EventEmitter() {}

	// Shortcuts to improve speed and size
	var proto = EventEmitter.prototype;
	var exports = this;
	var originalGlobalValue = exports.EventEmitter;

	/**
	 * Finds the index of the listener for the event in it's storage array.
	 *
	 * @param {Function[]} listeners Array of listeners to search through.
	 * @param {Function} listener Method to look for.
	 * @return {Number} Index of the specified listener, -1 if not found
	 * @api private
	 */
	function indexOfListener(listeners, listener) {
		var i = listeners.length;
		while (i--) {
			if (listeners[i].listener === listener) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Alias a method while keeping the context correct, to allow for overwriting of target method.
	 *
	 * @param {String} name The name of the target method.
	 * @return {Function} The aliased method
	 * @api private
	 */
	function alias(name) {
		return function aliasClosure() {
			return this[name].apply(this, arguments);
		};
	}

	/**
	 * Returns the listener array for the specified event.
	 * Will initialise the event object and listener arrays if required.
	 * Will return an object if you use a regex search. The object contains keys for each matched event. So /ba[rz]/ might return an object containing bar and baz. But only if you have either defined them with defineEvent or added some listeners to them.
	 * Each property in the object response is an array of listener functions.
	 *
	 * @param {String|RegExp} evt Name of the event to return the listeners from.
	 * @return {Function[]|Object} All listener functions for the event.
	 */
	proto.getListeners = function getListeners(evt) {
		var events = this._getEvents();
		var response;
		var key;

		// Return a concatenated array of all matching events if
		// the selector is a regular expression.
		if (typeof evt === 'object') {
			response = {};
			for (key in events) {
				if (events.hasOwnProperty(key) && evt.test(key)) {
					response[key] = events[key];
				}
			}
		}
		else {
			response = events[evt] || (events[evt] = []);
		}

		return response;
	};

	/**
	 * Takes a list of listener objects and flattens it into a list of listener functions.
	 *
	 * @param {Object[]} listeners Raw listener objects.
	 * @return {Function[]} Just the listener functions.
	 */
	proto.flattenListeners = function flattenListeners(listeners) {
		var flatListeners = [];
		var i;

		for (i = 0; i < listeners.length; i += 1) {
			flatListeners.push(listeners[i].listener);
		}

		return flatListeners;
	};

	/**
	 * Fetches the requested listeners via getListeners but will always return the results inside an object. This is mainly for internal use but others may find it useful.
	 *
	 * @param {String|RegExp} evt Name of the event to return the listeners from.
	 * @return {Object} All listener functions for an event in an object.
	 */
	proto.getListenersAsObject = function getListenersAsObject(evt) {
		var listeners = this.getListeners(evt);
		var response;

		if (listeners instanceof Array) {
			response = {};
			response[evt] = listeners;
		}

		return response || listeners;
	};

	/**
	 * Adds a listener function to the specified event.
	 * The listener will not be added if it is a duplicate.
	 * If the listener returns true then it will be removed after it is called.
	 * If you pass a regular expression as the event name then the listener will be added to all events that match it.
	 *
	 * @param {String|RegExp} evt Name of the event to attach the listener to.
	 * @param {Function} listener Method to be called when the event is emitted. If the function returns true then it will be removed after calling.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.addListener = function addListener(evt, listener) {
		var listeners = this.getListenersAsObject(evt);
		var listenerIsWrapped = typeof listener === 'object';
		var key;

		for (key in listeners) {
			if (listeners.hasOwnProperty(key) && indexOfListener(listeners[key], listener) === -1) {
				listeners[key].push(listenerIsWrapped ? listener : {
					listener: listener,
					once: false
				});
			}
		}

		return this;
	};

	/**
	 * Alias of addListener
	 */
	proto.on = alias('addListener');

	/**
	 * Semi-alias of addListener. It will add a listener that will be
	 * automatically removed after it's first execution.
	 *
	 * @param {String|RegExp} evt Name of the event to attach the listener to.
	 * @param {Function} listener Method to be called when the event is emitted. If the function returns true then it will be removed after calling.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.addOnceListener = function addOnceListener(evt, listener) {
		return this.addListener(evt, {
			listener: listener,
			once: true
		});
	};

	/**
	 * Alias of addOnceListener.
	 */
	proto.once = alias('addOnceListener');

	/**
	 * Defines an event name. This is required if you want to use a regex to add a listener to multiple events at once. If you don't do this then how do you expect it to know what event to add to? Should it just add to every possible match for a regex? No. That is scary and bad.
	 * You need to tell it what event names should be matched by a regex.
	 *
	 * @param {String} evt Name of the event to create.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.defineEvent = function defineEvent(evt) {
		this.getListeners(evt);
		return this;
	};

	/**
	 * Uses defineEvent to define multiple events.
	 *
	 * @param {String[]} evts An array of event names to define.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.defineEvents = function defineEvents(evts) {
		for (var i = 0; i < evts.length; i += 1) {
			this.defineEvent(evts[i]);
		}
		return this;
	};

	/**
	 * Removes a listener function from the specified event.
	 * When passed a regular expression as the event name, it will remove the listener from all events that match it.
	 *
	 * @param {String|RegExp} evt Name of the event to remove the listener from.
	 * @param {Function} listener Method to remove from the event.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.removeListener = function removeListener(evt, listener) {
		var listeners = this.getListenersAsObject(evt);
		var index;
		var key;

		for (key in listeners) {
			if (listeners.hasOwnProperty(key)) {
				index = indexOfListener(listeners[key], listener);

				if (index !== -1) {
					listeners[key].splice(index, 1);
				}
			}
		}

		return this;
	};

	/**
	 * Alias of removeListener
	 */
	proto.off = alias('removeListener');

	/**
	 * Adds listeners in bulk using the manipulateListeners method.
	 * If you pass an object as the second argument you can add to multiple events at once. The object should contain key value pairs of events and listeners or listener arrays. You can also pass it an event name and an array of listeners to be added.
	 * You can also pass it a regular expression to add the array of listeners to all events that match it.
	 * Yeah, this function does quite a bit. That's probably a bad thing.
	 *
	 * @param {String|Object|RegExp} evt An event name if you will pass an array of listeners next. An object if you wish to add to multiple events at once.
	 * @param {Function[]} [listeners] An optional array of listener functions to add.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.addListeners = function addListeners(evt, listeners) {
		// Pass through to manipulateListeners
		return this.manipulateListeners(false, evt, listeners);
	};

	/**
	 * Removes listeners in bulk using the manipulateListeners method.
	 * If you pass an object as the second argument you can remove from multiple events at once. The object should contain key value pairs of events and listeners or listener arrays.
	 * You can also pass it an event name and an array of listeners to be removed.
	 * You can also pass it a regular expression to remove the listeners from all events that match it.
	 *
	 * @param {String|Object|RegExp} evt An event name if you will pass an array of listeners next. An object if you wish to remove from multiple events at once.
	 * @param {Function[]} [listeners] An optional array of listener functions to remove.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.removeListeners = function removeListeners(evt, listeners) {
		// Pass through to manipulateListeners
		return this.manipulateListeners(true, evt, listeners);
	};

	/**
	 * Edits listeners in bulk. The addListeners and removeListeners methods both use this to do their job. You should really use those instead, this is a little lower level.
	 * The first argument will determine if the listeners are removed (true) or added (false).
	 * If you pass an object as the second argument you can add/remove from multiple events at once. The object should contain key value pairs of events and listeners or listener arrays.
	 * You can also pass it an event name and an array of listeners to be added/removed.
	 * You can also pass it a regular expression to manipulate the listeners of all events that match it.
	 *
	 * @param {Boolean} remove True if you want to remove listeners, false if you want to add.
	 * @param {String|Object|RegExp} evt An event name if you will pass an array of listeners next. An object if you wish to add/remove from multiple events at once.
	 * @param {Function[]} [listeners] An optional array of listener functions to add/remove.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.manipulateListeners = function manipulateListeners(remove, evt, listeners) {
		var i;
		var value;
		var single = remove ? this.removeListener : this.addListener;
		var multiple = remove ? this.removeListeners : this.addListeners;

		// If evt is an object then pass each of it's properties to this method
		if (typeof evt === 'object' && !(evt instanceof RegExp)) {
			for (i in evt) {
				if (evt.hasOwnProperty(i) && (value = evt[i])) {
					// Pass the single listener straight through to the singular method
					if (typeof value === 'function') {
						single.call(this, i, value);
					}
					else {
						// Otherwise pass back to the multiple function
						multiple.call(this, i, value);
					}
				}
			}
		}
		else {
			// So evt must be a string
			// And listeners must be an array of listeners
			// Loop over it and pass each one to the multiple method
			i = listeners.length;
			while (i--) {
				single.call(this, evt, listeners[i]);
			}
		}

		return this;
	};

	/**
	 * Removes all listeners from a specified event.
	 * If you do not specify an event then all listeners will be removed.
	 * That means every event will be emptied.
	 * You can also pass a regex to remove all events that match it.
	 *
	 * @param {String|RegExp} [evt] Optional name of the event to remove all listeners for. Will remove from every event if not passed.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.removeEvent = function removeEvent(evt) {
		var type = typeof evt;
		var events = this._getEvents();
		var key;

		// Remove different things depending on the state of evt
		if (type === 'string') {
			// Remove all listeners for the specified event
			delete events[evt];
		}
		else if (type === 'object') {
			// Remove all events matching the regex.
			for (key in events) {
				if (events.hasOwnProperty(key) && evt.test(key)) {
					delete events[key];
				}
			}
		}
		else {
			// Remove all listeners in all events
			delete this._events;
		}

		return this;
	};

	/**
	 * Alias of removeEvent.
	 *
	 * Added to mirror the node API.
	 */
	proto.removeAllListeners = alias('removeEvent');

	/**
	 * Emits an event of your choice.
	 * When emitted, every listener attached to that event will be executed.
	 * If you pass the optional argument array then those arguments will be passed to every listener upon execution.
	 * Because it uses `apply`, your array of arguments will be passed as if you wrote them out separately.
	 * So they will not arrive within the array on the other side, they will be separate.
	 * You can also pass a regular expression to emit to all events that match it.
	 *
	 * @param {String|RegExp} evt Name of the event to emit and execute listeners for.
	 * @param {Array} [args] Optional array of arguments to be passed to each listener.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.emitEvent = function emitEvent(evt, args) {
		var listeners = this.getListenersAsObject(evt);
		var listener;
		var i;
		var key;
		var response;

		for (key in listeners) {
			if (listeners.hasOwnProperty(key)) {
				i = listeners[key].length;

				while (i--) {
					// If the listener returns true then it shall be removed from the event
					// The function is executed either with a basic call or an apply if there is an args array
					listener = listeners[key][i];

					if (listener.once === true) {
						this.removeListener(evt, listener.listener);
					}

					response = listener.listener.apply(this, args || []);

					if (response === this._getOnceReturnValue()) {
						this.removeListener(evt, listener.listener);
					}
				}
			}
		}

		return this;
	};

	/**
	 * Alias of emitEvent
	 */
	proto.trigger = alias('emitEvent');

	/**
	 * Subtly different from emitEvent in that it will pass its arguments on to the listeners, as opposed to taking a single array of arguments to pass on.
	 * As with emitEvent, you can pass a regex in place of the event name to emit to all events that match it.
	 *
	 * @param {String|RegExp} evt Name of the event to emit and execute listeners for.
	 * @param {...*} Optional additional arguments to be passed to each listener.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.emit = function emit(evt) {
		var args = Array.prototype.slice.call(arguments, 1);
		return this.emitEvent(evt, args);
	};

	/**
	 * Sets the current value to check against when executing listeners. If a
	 * listeners return value matches the one set here then it will be removed
	 * after execution. This value defaults to true.
	 *
	 * @param {*} value The new value to check for when executing listeners.
	 * @return {Object} Current instance of EventEmitter for chaining.
	 */
	proto.setOnceReturnValue = function setOnceReturnValue(value) {
		this._onceReturnValue = value;
		return this;
	};

	/**
	 * Fetches the current value to check against when executing listeners. If
	 * the listeners return value matches this one then it should be removed
	 * automatically. It will return true by default.
	 *
	 * @return {*|Boolean} The current value to check for or the default, true.
	 * @api private
	 */
	proto._getOnceReturnValue = function _getOnceReturnValue() {
		if (this.hasOwnProperty('_onceReturnValue')) {
			return this._onceReturnValue;
		}
		else {
			return true;
		}
	};

	/**
	 * Fetches the events object and creates one if required.
	 *
	 * @return {Object} The events storage object.
	 * @api private
	 */
	proto._getEvents = function _getEvents() {
		return this._events || (this._events = {});
	};

	/**
	 * Reverts the global {@link EventEmitter} to its previous value and returns a reference to this version.
	 *
	 * @return {Function} Non conflicting EventEmitter class.
	 */
	EventEmitter.noConflict = function noConflict() {
		exports.EventEmitter = originalGlobalValue;
		return EventEmitter;
	};

	// Expose the class either via AMD, CommonJS or the global object
	if (typeof define === 'function' && define.amd) {
		define('eventEmitter/EventEmitter',[],function () {
			return EventEmitter;
		});
	}
	else if (typeof module === 'object' && module.exports){
		module.exports = EventEmitter;
	}
	else {
		this.EventEmitter = EventEmitter;
	}
}.call(this));

/*!
 * eventie v1.0.4
 * event binding helper
 *   eventie.bind( elem, 'click', myFn )
 *   eventie.unbind( elem, 'click', myFn )
 */

/*jshint browser: true, undef: true, unused: true */
/*global define: false */

( function( window ) {



var docElem = document.documentElement;

var bind = function() {};

function getIEEvent( obj ) {
  var event = window.event;
  // add event.target
  event.target = event.target || event.srcElement || obj;
  return event;
}

if ( docElem.addEventListener ) {
  bind = function( obj, type, fn ) {
    obj.addEventListener( type, fn, false );
  };
} else if ( docElem.attachEvent ) {
  bind = function( obj, type, fn ) {
    obj[ type + fn ] = fn.handleEvent ?
      function() {
        var event = getIEEvent( obj );
        fn.handleEvent.call( fn, event );
      } :
      function() {
        var event = getIEEvent( obj );
        fn.call( obj, event );
      };
    obj.attachEvent( "on" + type, obj[ type + fn ] );
  };
}

var unbind = function() {};

if ( docElem.removeEventListener ) {
  unbind = function( obj, type, fn ) {
    obj.removeEventListener( type, fn, false );
  };
} else if ( docElem.detachEvent ) {
  unbind = function( obj, type, fn ) {
    obj.detachEvent( "on" + type, obj[ type + fn ] );
    try {
      delete obj[ type + fn ];
    } catch ( err ) {
      // can't delete window object properties
      obj[ type + fn ] = undefined;
    }
  };
}

var eventie = {
  bind: bind,
  unbind: unbind
};

// transport
if ( typeof define === 'function' && define.amd ) {
  // AMD
  define( 'eventie/eventie',eventie );
} else {
  // browser global
  window.eventie = eventie;
}

})( this );

/*!
 * imagesLoaded v3.1.8
 * JavaScript is all like "You images are done yet or what?"
 * MIT License
 */

( function( window, factory ) { 
  // universal module definition

  /*global define: false, module: false, require: false */

  if ( typeof define === 'function' && define.amd ) {
    // AMD
    define( [
      'eventEmitter/EventEmitter',
      'eventie/eventie'
    ], function( EventEmitter, eventie ) {
      return factory( window, EventEmitter, eventie );
    });
  } else if ( typeof exports === 'object' ) {
    // CommonJS
    module.exports = factory(
      window,
      require('wolfy87-eventemitter'),
      require('eventie')
    );
  } else {
    // browser global
    window.imagesLoaded = factory(
      window,
      window.EventEmitter,
      window.eventie
    );
  }

})( window,

// --------------------------  factory -------------------------- //

function factory( window, EventEmitter, eventie ) {



var $ = window.jQuery;
var console = window.console;
var hasConsole = typeof console !== 'undefined';

// -------------------------- helpers -------------------------- //

// extend objects
function extend( a, b ) {
  for ( var prop in b ) {
    a[ prop ] = b[ prop ];
  }
  return a;
}

var objToString = Object.prototype.toString;
function isArray( obj ) {
  return objToString.call( obj ) === '[object Array]';
}

// turn element or nodeList into an array
function makeArray( obj ) {
  var ary = [];
  if ( isArray( obj ) ) {
    // use object if already an array
    ary = obj;
  } else if ( typeof obj.length === 'number' ) {
    // convert nodeList to array
    for ( var i=0, len = obj.length; i < len; i++ ) {
      ary.push( obj[i] );
    }
  } else {
    // array of single index
    ary.push( obj );
  }
  return ary;
}

  // -------------------------- imagesLoaded -------------------------- //

  /**
   * @param {Array, Element, NodeList, String} elem
   * @param {Object or Function} options - if function, use as callback
   * @param {Function} onAlways - callback function
   */
  function ImagesLoaded( elem, options, onAlways ) {
    // coerce ImagesLoaded() without new, to be new ImagesLoaded()
    if ( !( this instanceof ImagesLoaded ) ) {
      return new ImagesLoaded( elem, options );
    }
    // use elem as selector string
    if ( typeof elem === 'string' ) {
      elem = document.querySelectorAll( elem );
    }

    this.elements = makeArray( elem );
    this.options = extend( {}, this.options );

    if ( typeof options === 'function' ) {
      onAlways = options;
    } else {
      extend( this.options, options );
    }

    if ( onAlways ) {
      this.on( 'always', onAlways );
    }

    this.getImages();

    if ( $ ) {
      // add jQuery Deferred object
      this.jqDeferred = new $.Deferred();
    }

    // HACK check async to allow time to bind listeners
    var _this = this;
    setTimeout( function() {
      _this.check();
    });
  }

  ImagesLoaded.prototype = new EventEmitter();

  ImagesLoaded.prototype.options = {};

  ImagesLoaded.prototype.getImages = function() {
    this.images = [];

    // filter & find items if we have an item selector
    for ( var i=0, len = this.elements.length; i < len; i++ ) {
      var elem = this.elements[i];
      // filter siblings
      if ( elem.nodeName === 'IMG' ) {
        this.addImage( elem );
      }
      // find children
      // no non-element nodes, #143
      var nodeType = elem.nodeType;
      if ( !nodeType || !( nodeType === 1 || nodeType === 9 || nodeType === 11 ) ) {
        continue;
      }
      var childElems = elem.querySelectorAll('img');
      // concat childElems to filterFound array
      for ( var j=0, jLen = childElems.length; j < jLen; j++ ) {
        var img = childElems[j];
        this.addImage( img );
      }
    }
  };

  /**
   * @param {Image} img
   */
  ImagesLoaded.prototype.addImage = function( img ) {
    var loadingImage = new LoadingImage( img );
    this.images.push( loadingImage );
  };

  ImagesLoaded.prototype.check = function() {
    var _this = this;
    var checkedCount = 0;
    var length = this.images.length;
    this.hasAnyBroken = false;
    // complete if no images
    if ( !length ) {
      this.complete();
      return;
    }

    function onConfirm( image, message ) {
      if ( _this.options.debug && hasConsole ) {
        console.log( 'confirm', image, message );
      }

      _this.progress( image );
      checkedCount++;
      if ( checkedCount === length ) {
        _this.complete();
      }
      return true; // bind once
    }

    for ( var i=0; i < length; i++ ) {
      var loadingImage = this.images[i];
      loadingImage.on( 'confirm', onConfirm );
      loadingImage.check();
    }
  };

  ImagesLoaded.prototype.progress = function( image ) {
    this.hasAnyBroken = this.hasAnyBroken || !image.isLoaded;
    // HACK - Chrome triggers event before object properties have changed. #83
    var _this = this;
    setTimeout( function() {
      _this.emit( 'progress', _this, image );
      if ( _this.jqDeferred && _this.jqDeferred.notify ) {
        _this.jqDeferred.notify( _this, image );
      }
    });
  };

  ImagesLoaded.prototype.complete = function() {
    var eventName = this.hasAnyBroken ? 'fail' : 'done';
    this.isComplete = true;
    var _this = this;
    // HACK - another setTimeout so that confirm happens after progress
    setTimeout( function() {
      _this.emit( eventName, _this );
      _this.emit( 'always', _this );
      if ( _this.jqDeferred ) {
        var jqMethod = _this.hasAnyBroken ? 'reject' : 'resolve';
        _this.jqDeferred[ jqMethod ]( _this );
      }
    });
  };

  // -------------------------- jquery -------------------------- //

  if ( $ ) {
    $.fn.imagesLoaded = function( options, callback ) {
      var instance = new ImagesLoaded( this, options, callback );
      return instance.jqDeferred.promise( $(this) );
    };
  }


  // --------------------------  -------------------------- //

  function LoadingImage( img ) {
    this.img = img;
  }

  LoadingImage.prototype = new EventEmitter();

  LoadingImage.prototype.check = function() {
    // first check cached any previous images that have same src
    var resource = cache[ this.img.src ] || new Resource( this.img.src );
    if ( resource.isConfirmed ) {
      this.confirm( resource.isLoaded, 'cached was confirmed' );
      return;
    }

    // If complete is true and browser supports natural sizes,
    // try to check for image status manually.
    if ( this.img.complete && this.img.naturalWidth !== undefined ) {
      // report based on naturalWidth
      this.confirm( this.img.naturalWidth !== 0, 'naturalWidth' );
      return;
    }

    // If none of the checks above matched, simulate loading on detached element.
    var _this = this;
    resource.on( 'confirm', function( resrc, message ) {
      _this.confirm( resrc.isLoaded, message );
      return true;
    });

    resource.check();
  };

  LoadingImage.prototype.confirm = function( isLoaded, message ) {
    this.isLoaded = isLoaded;
    this.emit( 'confirm', this, message );
  };

  // -------------------------- Resource -------------------------- //

  // Resource checks each src, only once
  // separate class from LoadingImage to prevent memory leaks. See #115

  var cache = {};

  function Resource( src ) {
    this.src = src;
    // add to cache
    cache[ src ] = this;
  }

  Resource.prototype = new EventEmitter();

  Resource.prototype.check = function() {
    // only trigger checking once
    if ( this.isChecked ) {
      return;
    }
    // simulate loading on detached element
    var proxyImage = new Image();
    eventie.bind( proxyImage, 'load', this );
    eventie.bind( proxyImage, 'error', this );
    proxyImage.src = this.src;
    // set flag
    this.isChecked = true;
  };

  // ----- events ----- //

  // trigger specified handler for event type
  Resource.prototype.handleEvent = function( event ) {
    var method = 'on' + event.type;
    if ( this[ method ] ) {
      this[ method ]( event );
    }
  };

  Resource.prototype.onload = function( event ) {
    this.confirm( true, 'onload' );
    this.unbindProxyEvents( event );
  };

  Resource.prototype.onerror = function( event ) {
    this.confirm( false, 'onerror' );
    this.unbindProxyEvents( event );
  };

  // ----- confirm ----- //

  Resource.prototype.confirm = function( isLoaded, message ) {
    this.isConfirmed = true;
    this.isLoaded = isLoaded;
    this.emit( 'confirm', this, message );
  };

  Resource.prototype.unbindProxyEvents = function( event ) {
    eventie.unbind( event.target, 'load', this );
    eventie.unbind( event.target, 'error', this );
  };

  // -----  ----- //

  return ImagesLoaded;

});


</script>


    <script src="/vendors/imgrid/js/velocity.min.js"></script>
  <script src="/vendors/imgrid/js/velocity.ui.min.js"></script>




<script src="/vendors/imgrid/js/imgrid.min.js"></script>

<script>
$(document).ready(function () {
        $(".imgrid").imgrid({
            gridLoader: true,
			thumbSize: 200,
            gridLayout: 'masonry',
            gridAnimation: false,
            gridColumns: 4,
            thumbMargin: 4,
            thumbHoverEffect: 'apollo',
			gridAnimation: {
                trigger: 'onStart',
                animationType: 'bounceDown',
                animationDuration: 700,
                delay: true,
                offsetTop: 50,
                timeout: 0
            },
		});
		
		$('.filter').click(function (e) {
            e.preventDefault();
            console.log($(this).data('filter'));
            $(".imgrid").imgrid('filter', $(this).data('filter'));
        });
    });
</script>

<script>


window.psw_current_index = 0;

function buildItems() {
    const all_items = window.photoswipe_items;
    let items = [];
    if (Array.isArray(all_items) && all_items.length > 0) {
        all_items.forEach(original => {
            const item = {
                src: original.src,
                w: original.w,
                h: original.h
            };
            items.push(item);
        });
    }
    return items;
}

function initThumbnails() {
    const html_items = document.querySelectorAll('.psw-item');
    html_items.forEach((html_item, index) => {
        html_item.onclick = onThumbnailsClick;
    });
}

function updateThumbnails(psw_items) {
    const html_items = document.querySelectorAll('.psw-item');
    html_items.forEach((html_item, index) => {
        psw_items[index].el = html_item;
    });
    return psw_items;
}

function onThumbnailsClick(e) {
    e = e || window.event;
    e.preventDefault ? e.preventDefault() : e.returnValue = false;
    const target = e.target || e.srcElement;
    const index = target.dataset['index'];
    if (index >= 0) { // open PhotoSwipe if valid index found 
        openPhotoswipe(index);
    }
    return false;
}

function onTriggerClick(e) {
    e = e || window.event;
    e.preventDefault ? e.preventDefault() : e.returnValue = false;
    if (window.psw_current_index >= 0) {
        openPhotoswipe(window.psw_current_index);
    }
    return false;
}

function onMiniClick(e, psw_gallery) {
    e = e || window.event;
    e.preventDefault ? e.preventDefault() : e.returnValue = false;
    const target = e.target || e.srcElement;
    const index = target.dataset['index'];
    if (index >= 0) {
        psw_gallery.goTo(parseInt(index, 10));
    }
    return false;
}

function addMinis(psw_gallery) {
    const container = document.querySelectorAll('.pswp__minis-list')[0];
    const all_items = window.photoswipe_items;
    if (Array.isArray(all_items) && all_items.length > 0) {
        all_items.forEach((image, index) => {
            const link_el = document.createElement('a');
            const image_el = document.createElement('img');
            image_el.setAttribute('src', image.src);
            image_el.setAttribute('width', image.w);
            image_el.setAttribute('height', image.h);
            image_el.setAttribute('data-index', index);
            image_el.addEventListener('click', event => {
                return onMiniClick(event, psw_gallery);
            });
            link_el.className = 'pswp__mini';
            link_el.appendChild(image_el);
            container.appendChild(link_el);
        });
    }
}

function removeMinis(psw_gallery) {
    const container = document.querySelectorAll('.pswp__minis-list')[0];
    const minis = container.querySelectorAll('.pswp__mini');
    minis.forEach(el => {
        el.removeEventListener('click', event => {
            return onMiniClick(event, psw_gallery);
        });
        container.removeChild(el);
    });
}

function moveMinis(index) {
    const list_el = document.querySelectorAll('.pswp__minis-list')[0];
    const minis = list_el.querySelectorAll('.pswp__mini');
    const selected_mini = minis[index];
    const mini_width = 64; // Offset the container 
    const offset = -1 * mini_width * index;
    list_el.style.transform = `translate3d(${offset}px, 0, 0)`; // Highlight the current item 
    minis.forEach(el => {
        el.classList.remove('is-active');
    });
    selected_mini.classList.add('is-active');
}

function openPhotoswipe(index) {
    const psw_el = document.querySelectorAll('.pswp')[0];
    let psw_items = buildItems();
    psw_items = updateThumbnails(psw_items);
    const psw_options = {
        bgOpacity: 0.9,
        closeOnScroll: false,
        getThumbBoundsFn: function(index) {
            if (!psw_items[index].el) {
                return;
            }
            const thumbnail = psw_items[index].el.getElementsByTagName('img')[0];
            const pageYScroll = window.pageYOffset || document.documentElement.scrollTop;
            const rect = thumbnail.getBoundingClientRect();
            return {
                x: rect.left,
                y: rect.top + pageYScroll,
                w: rect.width
            };
        },
        history: false,
        index: parseInt(index, 10),
        preload: [1, 3],
        shareButtons: [{
            id: 'facebook',
            label: 'Share on Facebook',
            url: 'https://www.facebook.com/sharer/sharer.php?u={{url}}'
        }, {
            id: 'twitter',
            label: 'Tweet',
            url: 'https://twitter.com/intent/tweet?text={{text}}&url={{url}}'
        }]
    };
    if (isNaN(psw_options.index)) {
        return;
    }
    const psw_gallery = new PhotoSwipe(psw_el, PhotoSwipeUI_Default, psw_items, psw_options);
    psw_gallery.init();
    addMinis(psw_gallery);
    moveMinis(index);
    psw_gallery.listen('afterChange', () => {
        moveMinis(psw_gallery.getCurrentIndex());
    });
    psw_gallery.listen('imageLoadComplete', (index, item) => {
        const current_el = psw_gallery.currItem.container;
        current_el.addEventListener('contextmenu', event => event.preventDefault());
        window.psw_current_index = index;
    });
    psw_gallery.listen('close', () => {
        psw_el.classList.add('is-closing');
    });
    psw_gallery.listen('destroy', () => {
        removeMinis(psw_gallery);
        psw_el.classList.remove('is-closing');
    });
}
document.addEventListener('DOMContentLoaded', () => {
    initThumbnails();
    const psw_triggers = document.querySelectorAll('.psw-trigger');
    if (psw_triggers.length > 0) {
        psw_triggers.forEach(el => {
            el.onclick = onTriggerClick;
        });
    }
});


</script>

<%@ include file="WEB-INF/templates/contactCTA.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>