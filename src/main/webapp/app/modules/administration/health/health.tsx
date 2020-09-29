import React, { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import { Translate } from 'react-jhipster';
import { Badge, Button, Col, Row, Table } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { systemHealth } from '../administration.reducer';
import HealthModal from './health-modal';

export interface IHealthPageProps extends StateProps, DispatchProps {}

export const HealthPage = (props: IHealthPageProps) => {
  const [healthObject, setHealthObject] = useState({});
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    props.systemHealth();
  }, []);

  const getSystemHealth = () => {
    if (!props.isFetching) {
      props.systemHealth();
    }
  };

  const getSystemHealthInfo = (name, healthObj) => () => {
    setShowModal(true);
    setHealthObject({ ...healthObj, name });
  };

  const handleClose = () => setShowModal(false);

  const renderModal = () => <HealthModal healthObject={healthObject} handleClose={handleClose} showModal={showModal} />;

  const { health, isFetching } = props;
  const data = health ?? {};

  const nameMap = {
    jdbc: 'db',
  };

  if (data.details) {
    const mappedDetails = {};

    Object.keys(data.details).forEach(key => {
      const mappedKey = nameMap[key] ? nameMap[key] : key;
      mappedDetails[mappedKey] = data.details[key];
    });

    data.details = mappedDetails;
  }

  return (
    <div>
      <h2 id="health-page-heading">
        <Translate contentKey="health.title">Health Checks</Translate>
      </h2>
      <p>
        <Button onClick={getSystemHealth} color={isFetching ? 'btn btn-danger' : 'btn btn-primary'} disabled={isFetching}>
          <FontAwesomeIcon icon="sync" />
          &nbsp;
          <Translate component="span" contentKey="health.refresh.button">
            Refresh
          </Translate>
        </Button>
      </p>
      <Row>
        <Col md="12">
          <Table bordered aria-describedby="health-page-heading">
            <thead>
              <tr>
                <th>
                  <Translate contentKey="health.table.service">Service Name</Translate>
                </th>
                <th>
                  <Translate contentKey="health.table.status">Status</Translate>
                </th>
                <th>
                  <Translate contentKey="health.details.details">Details</Translate>
                </th>
              </tr>
            </thead>
            <tbody>
              {data.details
                ? Object.keys(data.details).map((configPropKey, configPropIndex) => (
                    <tr key={configPropIndex}>
                      <td>
                        <Translate contentKey={`health.indicator.${configPropKey}`}>{configPropKey}</Translate>
                      </td>
                      <td>
                        <Badge
                          color={data.details[configPropKey] ? (data.details[configPropKey].status !== 'UP' ? 'danger' : 'success') : null}
                        >
                          {data.status}
                        </Badge>
                      </td>
                      <td>
                        {data.details[configPropKey] ? (
                          <a onClick={getSystemHealthInfo(configPropKey, data.details[configPropKey])}>
                            <FontAwesomeIcon icon="eye" />
                          </a>
                        ) : null}
                      </td>
                    </tr>
                  ))
                : null}
            </tbody>
          </Table>
        </Col>
      </Row>
      {renderModal()}
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  health: storeState.administration.health,
  isFetching: storeState.administration.loading,
});

const mapDispatchToProps = { systemHealth };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(HealthPage);
