import React from 'react';
import { Translate } from 'react-jhipster';
import { Table, Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';

const formatDiskSpaceOutput = rawValue => {
  // Should display storage space in an human readable unit
  const val = rawValue / 1073741824;
  if (val > 1) {
    // Value
    return val.toFixed(2) + ' GB';
  } else {
    return (rawValue / 1048576).toFixed(2) + ' MB';
  }
};

const HealthModal = ({ handleClose, healthObject, showModal }) => {
  const data = healthObject.details || {};
  return (
    <Modal isOpen={showModal} size="lg" modalTransition={{ timeout: 20 }} backdropTransition={{ timeout: 10 }} toggle={handleClose}>
      <ModalHeader toggle={handleClose}>
        <Translate contentKey={`health.indicator.${healthObject.name}`}>{healthObject.name}</Translate>
      </ModalHeader>
      <ModalBody>
        <Table bordered>
          <thead>
            <tr>
              <th className="w-50">
                <Translate contentKey="health.details.name">Name</Translate>
              </th>
              <th className="w-50">
                <Translate contentKey="health.details.value">Value</Translate>
              </th>
            </tr>
          </thead>
          <tbody>
            {Object.keys(data).map((key, index) => (
              <tr key={index}>
                <td>{key}</td>
                <td>{healthObject.name === 'diskSpace' ? formatDiskSpaceOutput(data[key]) : JSON.stringify(data[key])}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </ModalBody>
      <ModalFooter>
        <Button color="primary" onClick={handleClose}>
          Close
        </Button>
      </ModalFooter>
    </Modal>
  );
};

export default HealthModal;
