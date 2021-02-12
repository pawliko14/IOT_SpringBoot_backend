import React,{Component} from 'react';

import './style.css';

import {Card,Table,Form,Button,Container,Row, FormControl } from 'react-bootstrap';

import axios from 'axios';

import {IP_PATH}  from './Constants';


export default class HistoricalData extends Component {


constructor(props)
{


super(props);
    this.state = {
            bounces : [],
            nazwisko_imie : "name",
            hacofostnumber : 1234,
            id_number : 1234,
            stanowisko : "null",
            firma: "null",
            creation_date : "null",
            worker_id : 2905411,
            count_rows : 30
    };

     this.handleChange = this.handleChange.bind(this);
     this.handleSubmit = this.handleSubmit.bind(this);

     this.handleRowChange = this.handleRowChange.bind(this);
     this.handleSubmit_rowChange = this.handleSubmit_rowChange.bind(this);
}

componentDidMount()
{
    axios.get( IP_PATH + "workerinfo/" + this.state.worker_id + "/" + this.state.count_rows)
        .then(response => response.data)
        .then((data) => {
            this.setState({bounces: data.bounceList, nazwisko_imie: data.nazwisko_imie, hacofostnumber: data.hacofostnumber,
                           id_number: data.id_number, stanowisko: data.stanowisko,
                           firma: data.firma, creation_date: data.creation_date})
        });



}


    handleRowChange(event){
    this.setState({
    count_rows: event.target.value
    });
    }
  handleSubmit_rowChange(event) {
    event.preventDefault();

     axios.get(IP_PATH + "workerinfo/" + this.state.worker_id + "/" + this.state.count_rows)
            .then(response => response.data)
                   .then((data) => {
                       this.setState({nazwisko_imie: data.nazwisko_imie, hacofostnumber: data.hacofostnumber,
                                      id_number: data.id_number, stanowisko: data.stanowisko,
                                      firma: data.firma, creation_date: data.creation_date , bounces: data.bounceList})
                   });

  }


  handleChange(event) {
    this.setState({
    worker_id: event.target.value
    });
  }

  handleSubmit(event) {
    event.preventDefault();

     axios.get(IP_PATH + "workerinfo/" + this.state.worker_id + "/" + this.state.count_rows)
            .then(response => response.data)
                   .then((data) => {
                       this.setState({nazwisko_imie: data.nazwisko_imie, hacofostnumber: data.hacofostnumber,
                                      id_number: data.id_number, stanowisko: data.stanowisko,
                                      firma: data.firma, creation_date: data.creation_date , bounces: data.bounceList})
                   });

  }

    render()
    {

        return (
        <div className = "wrapper">
        <div className = "lastActivitiesContainer">
         <div className = "leftDiv" >
           <Form onSubmit={this.handleSubmit}>
               <p className = {"border border-dark bg-dark text-white"}>Type Worker ID </p>
                  <label>
                    <input type="number" value={this.state.value} defaultValue= {this.state.worker_id} onChange={this.handleChange} />
                  </label>
                  <input type="submit" value="Submit"  />
                </Form>

                <Form onSubmit={this.handleSubmit_rowChange}>
                          <p className = {"border border-dark bg-dark text-white"}>Rows to show </p>
                               <label>
                              <input type="number" value={this.state.value} defaultValue = "30" onChange={this.handleRowChange}  min="1" max="200" />
                            </label>
                          <input type="submit" value="Submit"  />
                </Form>
            </div>

            <div className="rightDiv" >
              <Card className = {"border border-dark bg-dark text-white"}>
                       <Card.Header>Basic Worker informations</Card.Header>
                       <Card.Body>
                          <Table bordered hover striped variant = "dark">
                          <Table className = {"border border-dark bg-dark text-white"}>
                            <thead>
                              <tr>
                                <th>Card ID</th>
                                <th>HacoSoft Number</th>
                                <th>Starting Date</th>
                                <th>Name</th>
                                <th>Post</th>
                                <th>Company</th>
                              </tr>
                            </thead>
                            <tbody>
                                <tr key={this.state.id_number}>
                                     <td>{this.state.id_number} </td>
                                      <td>{this.state.hacofostnumber} </td>
                                       <td>{this.state.creation_date} </td>
                                        <td>{this.state.nazwisko_imie} </td>
                                         <td>{this.state.stanowisko} </td>
                                          <td>{this.state.firma} </td>
                                </tr>
                            </tbody>
                          </Table>
                          </Table>

                       </Card.Body>
                   </Card>

          </div>
        </div>

          <div className="bottom div" >
                        <Card className = {"border border-dark bg-dark text-white"}>
                                 <Card.Header>{this.state.nazwisko_imie} - For now list of bounces of particulat worker, in next version -> Graph, HardCoded last 20 records!!</Card.Header>
                                 <Card.Body>
                                    <Table bordered hover striped variant = "dark">
                                    <Table className = {"border border-dark bg-dark text-white"}>
                                      <thead>
                                        <tr>
                                          <th>#</th>
                                          <th>akcja</th>
                                          <th>data</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                      {this.state.bounces.length === 0 ?
                                                 <tr align="center">
                                                 <td colSpan ="3">{this.state.bounces.length} bounces</td>
                                                 </tr>
                                                 :
                                        this.state.bounces.map((bounce,index) =>(
                                                  <tr key={index}>
                                                        <td>{index+1} </td>
                                                        <td>{bounce.action} </td>
                                                        <td>{bounce.date} </td>
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

