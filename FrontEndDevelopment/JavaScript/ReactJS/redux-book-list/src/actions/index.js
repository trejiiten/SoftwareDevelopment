export function selectBook(book) {
    //console.log('A book has been selected: ', book.title);


    //selectBook is an ActionCreator. Needs to return
    //an Action: an object with a "type" property.
    return {
        type: 'BOOK_SELECTED',
        payload: book
    };
}

// Action ALWAYS contains "Type", sometimes contain "payload"