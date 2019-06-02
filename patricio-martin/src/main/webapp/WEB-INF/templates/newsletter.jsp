
 <section id="newsletter" class="section" style="background-color:#E7E5E0;    padding-bottom: 4.3rem;">
  <div class="container">
    <div class="columns" style="margin-top:10px;">
      <div class="column">
        <p class="title"  style="    color: #363636 !important;margin-top: -20px;"><fmt:message key="index.newsletter.title"/></p>
        <p class="subtitle is-4 has-text-grey-light"><fmt:message key="index.newsletter.paragraph"/></p>
      </div>

      <div class="column">
      
      
      
        <form action="/Subscribe" method="GET" accept-charset="utf-8">
        
          <div class="field is-grouped">
          
            <div class="control has-icons-left is-expanded">
              <input type="email" value="" name="email" class="input is-medium is-flat" placeholder="<fmt:message key="index.newsletter.inputPlaceholder"/>" required>
              <span class="icon is-small is-left">
                <svg class="svg-inline--fa fa-envelope fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="envelope" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M502.3 190.8c3.9-3.1 9.7-.2 9.7 4.7V400c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V195.6c0-5 5.7-7.8 9.7-4.7 22.4 17.4 52.1 39.5 154.1 113.6 21.1 15.4 56.7 47.8 92.2 47.6 35.7.3 72-32.8 92.3-47.6 102-74.1 131.6-96.3 154-113.7zM256 320c23.2.4 56.6-29.2 73.4-41.4 132.7-96.3 142.8-104.7 173.4-128.7 5.8-4.5 9.2-11.5 9.2-18.9v-19c0-26.5-21.5-48-48-48H48C21.5 64 0 85.5 0 112v19c0 7.4 3.4 14.3 9.2 18.9 30.6 23.9 40.7 32.4 173.4 128.7 16.8 12.2 50.2 41.8 73.4 41.4z"></path></svg><!-- <i class="fas fa-envelope"></i> -->
              </span>
            </div>

            <div class="control">
              <button class="button is-medium is-info" style="padding-bottom: calc(.375em - 1px) !important;padding-left: .75em !important;padding-right: .75em !important;padding-top: calc(.375em - 1px) !important;">
                <strong class="button-text"><fmt:message key="index.newsletter.btnSubscribe"/></strong>
              </button>
            </div>
            
          </div>
        </form>
        
        
        
      </div>
    </div>
  </div>
</section>
