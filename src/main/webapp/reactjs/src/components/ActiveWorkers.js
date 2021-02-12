import React,{Component} from 'react';

import {Card,Table,Form,Button} from 'react-bootstrap';

import axios from 'axios'

import {IP_PATH}  from './Constants';



export default class ActiveWorkers extends Component {



            constructor(props)
            {
            super(props);
                this.state = {
                        persons : []
                };
            }

            componentDidMount()
            {
                axios.get(IP_PATH +"activeworkers")
                    .then(response => response.data)
                    .then((data) => {
                        this.setState({persons: data})
                    });
            }



                render()
                {

                         return (
                            <div className = "lastActivitiesContainer">
                             <div className = "leftDiv" >

                                <Form className = {"border border-dark bg-dark text-white"}>
                                  <Form.Group controlId="formBasicEmail">
                                    <p class="text-center">if row is RED </p>
                                    <p class="text-center">it means that this worker </p>
                                    <p class="text-center">is absent today or</p>
                                    <p class="text-center">there was no bounce on entrance </p>
                                  </Form.Group>

                                </Form>
                              </div>

                               <div className="rightDiv">
                                 <Card className = {"border border-dark bg-dark text-white"}>
                                   <Card.Header>List of All workers who bounce at the FAT entrance gate </Card.Header>
                                   <Card.Body>
                                      <Table bordered hover striped variant = "dark">
                                      <Table className = {"border border-dark bg-dark text-white"}>
                                        <thead>
                                          <tr>
                                            <th>#</th>
                                            <th>worker Name</th>
                                             <th>workers ID</th>
                                            <th>work post</th>
                                            <th>Company</th>

                                          </tr>
                                        </thead>
                                        <tbody>
                                        {this.state.persons.length === 0 ?
                                          <tr align="center">
                                          <td colSpan ="7">{this.state.persons.length} persons</td>
                                          </tr>
                                          :
                                          this.state.persons.map((person,index) =>(
                                              person.akcja == "jest w firmie" ?

                                             <tr key={person.id_karty}  >
                                                  <td>{index+1} </td>
                                                  <td>{person.nazwisko_imie} </td>
                                                  <td>{person.id_karty} </td>
                                                  <td>{person.stanowisko} </td>
                                                  <td>{person.firma} </td>
                                            </tr>
                                              :
                                              <tr class="bg-danger" key={person.id_karty}  >
                                                    <td>{index+1} </td>
                                                    <td>{person.nazwisko_imie} </td>
                                                    <td>{person.id_karty} </td>
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