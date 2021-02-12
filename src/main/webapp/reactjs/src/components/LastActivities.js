import React,{Component} from 'react';

import './style.css';

import {Card,Table,Form,Button,Container,Row, FormControl } from 'react-bootstrap';

import axios from 'axios';
import {IP_PATH}  from './Constants';



export default class LastActivities extends Component {

constructor(props)
{
super(props);
    this.state = {
            persons : [],
            count_numbers : 30
    };

     this.handleChange = this.handleChange.bind(this);
     this.handleSubmit = this.handleSubmit.bind(this);
}

componentDidMount()
{

this.loadData()
this.timer = setInterval(() => {
    this.loadData();
    },2000);
}


componentWillUnmount() {
        clearInterval(this.timer);
    }

loadData()
{
    try {
     const response =  axios.get(IP_PATH + "lastinout/" + this.state.count_numbers)
        .then(response => response.data)
        .then((data) => {
            this.setState({persons: data})
        });
        }
        catch(e)
        {
        console.log(e);
        }

}



  handleChange(event) {
    this.setState({count_numbers: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();

     axios.get(IP_PATH + "lastinout/" + this.state.count_numbers)
            .then(response => response.data)
            .then((data) => {
                this.setState({persons: data})
            });

        console.log("length: " + this.state.persons.length);


  }

    render()
    {

        return (
        <div className = "lastActivitiesContainer">
         <div className = "leftDiv" >
           <Form onSubmit={this.handleSubmit}>
               <p className = {"border border-dark bg-dark text-white"}>Number of rows - default 30</p>
                  <label>
                    <input type="number" value={this.state.value} onChange={this.handleChange} min="1" max="200"/>
                  </label>
                  <input type="submit" value="Submit"  />
                </Form>



            </div>

            <div className="rightDiv" >
              <Card className = {"border border-dark bg-dark text-white"}>
                       <Card.Header>Last activities on entrance gate</Card.Header>
                       <Card.Body>
                          <Table bordered hover striped variant = "dark">
                          <Table className = {"border border-dark bg-dark text-white"}>
                            <thead>
                              <tr>
                                <th>#</th>
                                <th>id</th>
                                <th>id_karty</th>
                                <th>akcja</th>
                                <th>data</th>
                                <th>nazwisko imie</th>
                                <th>stanowisko</th>
                                <th>firma</th>
                              </tr>
                            </thead>
                            <tbody>
                            {this.state.persons.length === 0 ?
                              <tr align="center">
                              <td colSpan ="8">{this.state.persons.length} persons</td>
                              </tr>
                              :
                              this.state.persons.map((person,index) =>(
                              <tr key={index}>
                                    <td>{index+1} </td>
                                    <td>{person.id} </td>
                                    <td>{person.id_karty} </td>
                                    <td>{person.akcja} </td>
                                    <td>{person.data} </td>
                                    <td>{person.nazwisko_imie} </td>
                                    <td>{person.stanowisko} </td>
                                     <td>{person.firma} </td>
                              </tr>

                              ))


                              }
                            </tbody>
                          </Table>
                          </Table>

                       </Card.Body>
                   </Card>

          </div>
        </div>

        );
    }
}

