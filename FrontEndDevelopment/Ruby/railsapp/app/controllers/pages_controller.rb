class PagesController < ApplicationController
    def index
        @title = "Howdy"
        @content = "Welcome to the homepage."
    end

    def about
        @title = "About"
        @content = "Welcome to the About page."
    end

    def services
        @title = "Services"
        @content = "Welcome to the Services page."
        @services = ['Web Design', 'Web Development', 'SEO']
    end

    def contact
        @title = "Contact"
        @content = "Welcome to the Contact page."
    end
end
