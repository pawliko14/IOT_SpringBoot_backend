import React from 'react';

import {Jumbotron} from 'react-bootstrap';


class Welcome extends React.Component{
    render()
     {
     return (
                <Jumbotron className="bg-dark text-white">
                  <h1>Home Page</h1>
                  <p>
                    This programs provides information about FAT workers entrace states.
                    At this stage following options are provided:
                    <ul>
                        <li>
                            Active workers status
                        </li>
                        <li>
                            Current state(amount) of workers
                        </li>
                        <li>
                            Informations about last actions on entrance gate
                        </li>
                        <li>
                            Historical data of specific worker(under development) - DONE
                        </li>
                        <li>
                            Logout, Login, Staticis NOT implemeted yet
                        </li>
                    </ul>
                        last Stable version 28.12.2020
                  </p>
                </Jumbotron>
     );
     }

}

export default Welcome;