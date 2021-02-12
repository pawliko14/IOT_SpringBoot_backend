import './App.css';
import React from 'react';

import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import {Container,Row,Col} from 'react-bootstrap';

import Welcome from './components/Welcome';
import Footer from './components/Footer';

import ActiveWorkers from './components/ActiveWorkers';
import CurrentState from './components/CurrentState';
import LastActivities from './components/LastActivities';

import Statistics from './components/Statistics';
import HistoricalData from './components/HistoricalData';

import Login from "./components/Login";
import Logout from "./components/Logout";


function App() {

    const marginTop = {
        marginTop:"20px"
    };


  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
            <Col lg={12} style={marginTop}>
                <Switch>
                    <Route path = "/" exact component={Welcome} />
                    <Route path = "/currentstate" exact component={CurrentState} />
                    <Route path = "/activeworkers" exact component={ActiveWorkers} />
                    <Route path = "/lastactivities" exact component={LastActivities} />
                    <Route path = "/Statistics" exact component={Statistics} />
                    <Route path = "/HistoricalData" exact component={HistoricalData} />
                    <Route path = "/Login" exact component={Login} />
                    <Route path = "/Logout" exact component={Logout} />

                </Switch>
             </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );
}

export default App;
