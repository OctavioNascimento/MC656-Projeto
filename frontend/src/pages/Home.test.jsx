import { render, screen } from '@testing-library/react'
import Home from './Home'

test('Should render a button with text "LOGIN"', () => {
     render(<Home />)
     expect(screen.getByText("PÁGINA INICIAL")).toBeInTheDocument()
})
