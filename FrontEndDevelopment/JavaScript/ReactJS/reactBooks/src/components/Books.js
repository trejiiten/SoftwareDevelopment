import React, { Component } from 'react';
import { Grid, Col, Row, PanelGroup, Panel, ListGroup, ListGroupItem, Button } from 'react-bootstrap';

class Books extends Component {
    
    render() {
        let bookItems;
        if(this.props.books){
            bookItems = this.props.books.map(book => {
                let id = book.id;
                let title = book.volumeInfo.title;
                
                let thumbnail = book.volumeInfo.imageLinks.thumbnail;
                let categories = book.volumeInfo.categories;
                if(!categories){categories = 'N/A';}
                let authors = book.volumeInfo.authors;
                let publisher = book.volumeInfo.publisher;
                if(!publisher){publisher = 'N/A';}
                let description = book.volumeInfo.description;
                let pageCount = book.volumeInfo.pageCount;
                let publishedDate = book.volumeInfo.publishedDate;
                let averageRating = book.volumeInfo.averageRating;
                if(!averageRating){averageRating = 'N/A';}
                let buyLink = book.saleInfo.buyLink;

                //thumbnail: "http://books.google.com/books/content?id=ti3Qbej5wg4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"


                return (
                    <Panel key={id} header={title} eventKey={id}>
                        <Panel.Heading>
                            <Panel.Title toggle>
                                {title}
                            </Panel.Title>
                        </Panel.Heading>
                        <Panel.Body collapsible>
                            <Grid>
                                <Row>
                                    <Col xs={11} sm={3} md={3} lg={3}>
                                       <img src={thumbnail} alt="presentation" className="thumbnail" />
                                    </Col>
                                    <Col xs={11} sm={8} md={8} lg={8}>
                                        <ListGroup>
                                        {/* <h1>{authors}</h1>
                                        <p>{description}</p> */}
                                            <ListGroupItem>
                                                <strong>Categories: </strong> {categories}
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <strong>Author(s): </strong> {authors}
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <strong>Publisher: </strong> {publisher}
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <strong>Publish Date: </strong> {publishedDate}
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <strong>Page Count: </strong> {pageCount}
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <strong>Average Rating: </strong> <span className="rating">{averageRating}</span>
                                            </ListGroupItem>
                                        </ListGroup>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col xs={11} md={11} lg={11}>
                                        <h3>Book Description:</h3>
                                        {description}
                                        <hr />
                                        <Button href={buyLink} bsStyle="primary">Buy Me!</Button>
                                    </Col>
                                </Row>
                            </Grid>
                        </Panel.Body>
                    </Panel>
                )
            })
        }
        return (
            <div>
                <PanelGroup accordion id="accordion-uncontrolled">
                    {bookItems}
                </PanelGroup>
            </div>
        );
    }
}

export default Books;