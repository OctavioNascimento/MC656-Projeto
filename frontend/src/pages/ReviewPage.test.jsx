import { render, screen } from '@testing-library/react'
import { MemoryRouter } from 'react-router-dom';
import ReviewPage from './ReviewPage';

test('Should render a input with a text "Avaliação"', () => {
  render(
    <MemoryRouter>
      <ReviewPage />
    </MemoryRouter>
  )
  expect(screen.getByText('Avaliação')).toBeInTheDocument();
})